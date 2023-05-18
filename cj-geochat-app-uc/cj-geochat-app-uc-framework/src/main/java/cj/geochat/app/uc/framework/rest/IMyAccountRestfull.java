package cj.geochat.app.uc.framework.rest;

import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.model.UcLoginAccount;

import java.util.List;

public interface IMyAccountRestfull {
    List<UcLoginAccount> listMyAccount(String userId);

    UcLoginAccount getAccount(String accountId);

    void removeMyAccounts(String userId);

    UcLoginAccount findMyAccount(LoginAccountCategory category, String openCode);

    void removeMyAccount(String openCode, LoginAccountCategory loginAccountCategory);
}
