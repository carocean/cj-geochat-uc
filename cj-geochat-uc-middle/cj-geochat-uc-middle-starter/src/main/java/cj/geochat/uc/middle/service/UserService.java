package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.ability.util.DateUtils;
import cj.geochat.uc.middle.GenderType;
import cj.geochat.uc.middle.UserStatus;
import cj.geochat.uc.middle.mapper.UcUserDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.UcUserMapper;
import cj.geochat.uc.middle.model.UcUser;
import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.annotation.Resource;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class UserService implements IUserService {
    @Resource
    UcUserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public String createUser(String avatar, String nickName, String password, String countryCode, String countryName, boolean isAgreeUPA) {
        UcUser user = new UcUser();
        user.setId(UlidCreator.getUlid().toLowerCase());
        user.setStatus(UserStatus.normal.name());
        user.setPassword(passwordEncoder.encode(password));
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

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcUser> listUser(int limit, int offset) {
        SelectStatementProvider provider = SqlBuilder.select(UcUserDynamicSqlSupport.ucUser.allColumns())
                .from(UcUserDynamicSqlSupport.ucUser)
                .limit(limit)
                .offset(offset)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return userMapper.selectMany(provider);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcUser getUser(String userId) {
        return userMapper.selectByPrimaryKey(userId).orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcUser findUserByPhone(String phone) {
        return userMapper.select(c -> c
                .where(UcUserDynamicSqlSupport.phone, SqlBuilder.isEqualTo(phone))
                .limit(1)
        ).stream().findAny().orElse(null);
    }

    @AccessDBPolicy.ReadOnly
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
                .set(UcUserDynamicSqlSupport.ucUser.password)
                .equalTo(pwd)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.updatePwdTime)
                .equalTo(DateUtils.dateToLen17(new Date(System.currentTimeMillis())))
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateLoginTIme(String userId) {
        String lastLoginTime = DateUtils.dateToLen17(new Date(System.currentTimeMillis()));
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.lastLoginTime)
                .equalTo(lastLoginTime)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateStatus(String userId, UserStatus status) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.status)
                .equalTo(status.name())
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateAvatar(String userId, String avatar) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.avatar)
                .equalTo(avatar)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateInfo(String userId, String realName, String email, String phone) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.realName).equalTo(realName)
                .set(UcUserDynamicSqlSupport.ucUser.email).equalTo(email)
                .set(UcUserDynamicSqlSupport.ucUser.phone).equalTo(phone)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateNickName(String userId, String nickName) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.nickName).equalTo(nickName)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateIntro(String userId, String intro) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.userIntro).equalTo(intro)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateMajorAccount(String userId, String accountId) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.majorAccount).equalTo(accountId)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updatePhone(String userId, String phone) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.phone).equalTo(phone)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateEmail(String userId, String email) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.email).equalTo(email)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateRealName(String userid, String realName) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.realName).equalTo(realName)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userid))
        );
    }

    @Transactional
    @Override
    public void updateGender(String userid, GenderType gender) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.realName).equalTo(UcUserDynamicSqlSupport.realName.name())
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userid))
        );
    }

    @Transactional
    @Override
    public void updateCountry(String userid, String countryCode, String countryName) {
        userMapper.update(c -> c
                .set(UcUserDynamicSqlSupport.ucUser.countryCode).equalTo(countryCode)
                .set(UcUserDynamicSqlSupport.ucUser.countrName).equalTo(countryName)
                .where(UcUserDynamicSqlSupport.ucUser.id, SqlBuilder.isEqualTo(userid))
        );
    }
}
