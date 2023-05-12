package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.ability.util.DateUtils;
import cj.geochat.middle.uc.UserStatus;
import cj.geochat.middle.uc.mapper.UcUserMapper;
import cj.geochat.middle.uc.model.UcUser;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
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
    public void addUser(UcUser user) {
        userMapper.insertSelective(user);
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
        return userMapper.selectByPrimaryKey(userId).get();
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
        byte state = 0;
        switch (status) {
            case normal:
                state = 0;
                break;
            case personalStop:
                state = 1;
                break;
            case platformFrozen:
                state = 2;
                break;
            default:
                throw new RuntimeException("不支持的状态。status=" + status);
        }
        byte finalState = state;
        userMapper.update(c -> c
                .set(ucUser.status)
                .equalTo(finalState)
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
}
