package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.LoginAccountStatus;
import cj.geochat.middle.uc.model.UcLoginAccount;

import java.util.List;

public interface ILoginAccountService {
    void addAccount(UcLoginAccount account);

    void removeAccount(String account_id);

    List<UcLoginAccount> listAccount(int limit, int offset);

    List<UcLoginAccount> listAccountByUser(String userId);

    UcLoginAccount getAccount(String accountId);

    void removeAccountsByUser(String userId);

    UcLoginAccount findAccount(String category,String openCode);

    void updateStatus(String accountId, LoginAccountStatus status);
}
