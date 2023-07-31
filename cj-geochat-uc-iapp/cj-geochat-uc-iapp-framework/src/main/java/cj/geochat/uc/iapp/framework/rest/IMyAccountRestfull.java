package cj.geochat.uc.iapp.framework.rest;

import cj.geochat.uc.middle.LoginAccountCategory;
import cj.geochat.uc.middle.model.UcLoginAccount;

import java.util.List;

public interface IMyAccountRestfull {
    List<UcLoginAccount> listMyAccount(String userId);

    UcLoginAccount getAccount(String accountId);

    void removeMyAccounts(String userId);

    UcLoginAccount findMyAccount(LoginAccountCategory category, String openCode);

    void removeMyAccount(String openCode, LoginAccountCategory loginAccountCategory);
}
