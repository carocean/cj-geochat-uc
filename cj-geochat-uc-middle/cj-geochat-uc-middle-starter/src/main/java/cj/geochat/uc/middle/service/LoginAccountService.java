package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.ability.util.DateUtils;
import cj.geochat.uc.middle.LoginAccountCategory;
import cj.geochat.uc.middle.mapper.UcLoginAccountDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.UcLoginAccountMapper;
import cj.geochat.uc.middle.model.UcLoginAccount;
import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.annotation.Resource;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class LoginAccountService implements ILoginAccountService {
    @Resource
    UcLoginAccountMapper loginAccountMapper;

    @Transactional
    @Override
    public String createAccount(String userId, String openCode, LoginAccountCategory category) {
        UcLoginAccount account = new UcLoginAccount();
        account.setId(UlidCreator.getUlid().toLowerCase());
        account.setCtime(DateUtils.dateToLen17(new Date(System.currentTimeMillis())));
        account.setUserId(userId);
        account.setCategory(category.name());
        account.setOpenCode(openCode);
        loginAccountMapper.insertSelective(account);
        return account.getId();
    }

    @Transactional
    @Override
    public void removeAccount(String account_id) {
        loginAccountMapper.deleteByPrimaryKey(account_id);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcLoginAccount> listAccount(int limit, int offset) {
        return loginAccountMapper.select(c -> c.limit(limit).offset(offset));
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcLoginAccount> listAccountByUser(String userId) {
        return loginAccountMapper.select(c -> c.where(UcLoginAccountDynamicSqlSupport.ucLoginAccount.userId, SqlBuilder.isEqualTo(userId)));
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcLoginAccount> listAccountOnUser(String userId, String category) {
        return loginAccountMapper.select(c -> c
                .where(UcLoginAccountDynamicSqlSupport.category, SqlBuilder.isEqualTo(category))
                .and(UcLoginAccountDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcLoginAccount getAccount(String accountId) {
        return loginAccountMapper.selectByPrimaryKey(accountId).orElse(null);
    }

    @Transactional
    @Override
    public void removeAccountsByUser(String userId) {
        loginAccountMapper.delete(c -> c.where(UcLoginAccountDynamicSqlSupport.ucLoginAccount.userId, SqlBuilder.isEqualTo(userId)));
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcLoginAccount findAccount(String category, String openCode) {
        List<UcLoginAccount> list = loginAccountMapper.select(c -> c
                .where(UcLoginAccountDynamicSqlSupport.ucLoginAccount.openCode, SqlBuilder.isEqualTo(openCode))
                .and(UcLoginAccountDynamicSqlSupport.ucLoginAccount.category, SqlBuilder.isEqualTo(category))
                .limit(1)
        );
        return list.isEmpty() ? null : list.get(0);
    }

    @Transactional
    @Override
    public void removeAccountByOpenCode(String userid, String openCode, LoginAccountCategory loginAccountCategory) {
        loginAccountMapper.delete(c -> c
                .where(UcLoginAccountDynamicSqlSupport.ucLoginAccount.userId, SqlBuilder.isEqualTo(userid))
                .and(UcLoginAccountDynamicSqlSupport.openCode, SqlBuilder.isEqualTo(openCode))
                .and(UcLoginAccountDynamicSqlSupport.category, SqlBuilder.isEqualTo(loginAccountCategory.name()))
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcLoginAccount findAccountBy(String userid, LoginAccountCategory category, String openCode) {
        return loginAccountMapper.select(c -> c
                .where(UcLoginAccountDynamicSqlSupport.category, SqlBuilder.isEqualTo(category.name()))
                .and(UcLoginAccountDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userid))
                .and(UcLoginAccountDynamicSqlSupport.openCode, SqlBuilder.isEqualTo(openCode))
                .limit(1)
        ).stream().findFirst().orElse(null);
    }
}
