package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.ability.util.DateUtils;
import cj.geochat.middle.uc.UserStatus;
import cj.geochat.middle.uc.mapper.UcUserDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.UcUserMapper;
import cj.geochat.middle.uc.model.UcUser;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

import static cj.geochat.middle.uc.mapper.UcUserDynamicSqlSupport.ucUser;

@Service
public class UserService implements IUserService {
    @Resource
    UcUserMapper userMapper;

    @Transactional
    @Override
    public String createUser(String avatar, String nickName, String password, String countryCode, String countryName, boolean isAgreeUPA) {
        UcUser user = new UcUser();
        user.setId(UlidCreator.getUlid().toLowerCase());
        user.setStatus(UserStatus.normal.name());
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setNickName(nickName);
        user.setAvatar(avatar);
        user.setAgreeUpa(isAgreeUPA);
        user.setCountryCode(countryCode);
        user.setCountrName(countryName);
        user.setCtime(DateUtils.dateToLen17(new Date(System.currentTimeMillis())));
        user.setUpdatePwdTime(user.getCtime());
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Transactional
    @Override
    public void removeUser(String userId) {
        userMapper.deleteByPrimaryKey(userId);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<UcUser> listUser(int limit, int offset) {
        SelectStatementProvider provider = SqlBuilder.select(ucUser.allColumns())
                .from(ucUser)
                .limit(limit)
                .offset(offset)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return userMapper.selectMany(provider);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public UcUser getUser(String userId) {
        return userMapper.selectByPrimaryKey(userId).orElse(null);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public UcUser findUserByPhone(String phone) {
        return userMapper.select(c -> c
                .where(UcUserDynamicSqlSupport.phone, SqlBuilder.isEqualTo(phone))
                .limit(1)
        ).stream().findAny().orElse(null);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public UcUser findUserByEmail(String email) {
        return userMapper.select(c -> c
                .where(UcUserDynamicSqlSupport.email, SqlBuilder.isEqualTo(email))
                .limit(1)
        ).stream().findAny().orElse(null);
    }

    @Transactional
    @Override
    public void updatePwd(String userId, String pwd) {
        userMapper.update(c -> c
                .set(ucUser.password)
                .equalTo(pwd)
                .where(ucUser.id, SqlBuilder.isEqualTo(userId))
        );
        userMapper.update(c -> c
                .set(ucUser.updatePwdTime)
                .equalTo(DateUtils.dateToLen17(new Date(System.currentTimeMillis())))
                .where(ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateLoginTIme(String userId) {
        String lastLoginTime = DateUtils.dateToLen17(new Date(System.currentTimeMillis()));
        userMapper.update(c -> c
                .set(ucUser.lastLoginTime)
                .equalTo(lastLoginTime)
                .where(ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateStatus(String userId, UserStatus status) {
        userMapper.update(c -> c
                .set(ucUser.status)
                .equalTo(status.name())
                .where(ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateAvatar(String userId, String avatar) {
        userMapper.update(c -> c
                .set(ucUser.avatar)
                .equalTo(avatar)
                .where(ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateInfo(String userId, String realName, String email, String phone) {
        userMapper.update(c -> c
                .set(ucUser.realName).equalTo(realName)
                .set(ucUser.email).equalTo(email)
                .set(ucUser.phone).equalTo(phone)
                .where(ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateNickName(String userId, String nickName) {
        userMapper.update(c -> c
                .set(ucUser.nickName).equalTo(nickName)
                .where(ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateIntro(String userId, String intro) {
        userMapper.update(c -> c
                .set(ucUser.userIntro).equalTo(intro)
                .where(ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateMajorAccount(String userId, String accountId) {
        userMapper.update(c -> c
                .set(ucUser.majorAccount).equalTo(accountId)
                .where(ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }
@Transactional
    @Override
    public void updatePhone(String userId,String phone) {
    userMapper.update(c -> c
            .set(ucUser.phone).equalTo(phone)
            .where(ucUser.id, SqlBuilder.isEqualTo(userId))
    );
    }
@Transactional
    @Override
    public void updateEmail(String userId,String email) {
    userMapper.update(c -> c
            .set(ucUser.email).equalTo(email)
            .where(ucUser.id, SqlBuilder.isEqualTo(userId))
    );
    }
}
