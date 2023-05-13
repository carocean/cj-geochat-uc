package cj.geochat.middle.uc.web;

import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.LoginAccountStatus;
import cj.geochat.middle.uc.model.UcLoginAccount;

import java.util.List;

public interface ILoginAccountRestfull {
    String createAccount(String userId, String openCode, LoginAccountCategory category);

    void removeAccount(String account_id);

    List<UcLoginAccount> listAccount(int limit, int offset);

    List<UcLoginAccount> listAccountByUser(String userId);

    UcLoginAccount getAccount(String accountId);

    void removeAccountsByUser(String userId);

    UcLoginAccount findAccount(String category,String openCode);

    void updateStatus(String accountId, LoginAccountStatus status);
}
