package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.ability.util.DateUtils;
import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.LoginAccountStatus;
import cj.geochat.middle.uc.mapper.UcLoginAccountDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.UcLoginAccountMapper;
import cj.geochat.middle.uc.model.UcLoginAccount;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
        account.setStatus(LoginAccountStatus.normal.name());
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

    @DataSourceConfig.ReadOnly
    @Override
    public List<UcLoginAccount> listAccount(int limit, int offset) {
        return loginAccountMapper.select(c -> c.limit(limit).offset(offset));
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<UcLoginAccount> listAccountByUser(String userId) {
        return loginAccountMapper.select(c -> c.where(UcLoginAccountDynamicSqlSupport.ucLoginAccount.userId, SqlBuilder.isEqualTo(userId)));
    }

    @DataSourceConfig.ReadOnly
    @Override
    public UcLoginAccount getAccount(String accountId) {
        return loginAccountMapper.selectByPrimaryKey(accountId).orElse(null);
    }

    @Transactional
    @Override
    public void removeAccountsByUser(String userId) {
        loginAccountMapper.delete(c -> c.where(UcLoginAccountDynamicSqlSupport.ucLoginAccount.userId, SqlBuilder.isEqualTo(userId)));
    }

    @DataSourceConfig.ReadOnly
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
    public void updateStatus(String accountId, LoginAccountStatus status) {
        loginAccountMapper.update(c -> c
                .set(UcLoginAccountDynamicSqlSupport.ucLoginAccount.status).equalTo(status.name())
                .where(UcLoginAccountDynamicSqlSupport.ucLoginAccount.id, SqlBuilder.isEqualTo(accountId))
        );
    }
}
