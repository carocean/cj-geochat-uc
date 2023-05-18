package cj.geochat.app.uc.remote;

import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.model.UcLoginAccount;
import cj.geochat.middle.uc.web.rest.ILoginAccountRestfull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "loginAccountRemote", value = "cj-geochat-middle-uc", url = "${app.test.feign.adapter.docker.uc.url:}")
public interface LoginAccountRemote extends ILoginAccountRestfull {
    @RequestMapping(value = "/api/v1/account/createAccount", method = RequestMethod.GET)
    @Override
    String createAccount(@RequestParam String userId, @RequestParam String openCode,@RequestParam LoginAccountCategory category);
    @RequestMapping(value = "/api/v1/account/listAccountByUser", method = RequestMethod.GET)
    @Override
    List<UcLoginAccount> listAccountByUser(@RequestParam String userId);
    @RequestMapping(value = "/api/v1/account/getAccount", method = RequestMethod.GET)
    @Override
    UcLoginAccount getAccount(@RequestParam String accountId);
    @RequestMapping(value = "/api/v1/account/removeAccountsByUser", method = RequestMethod.GET)
    @Override
    void removeAccountsByUser(@RequestParam String userId);
    @RequestMapping(value = "/api/v1/account/removeAccountByOpenCode", method = RequestMethod.GET)
    @Override
    void removeAccountByOpenCode(@RequestParam String userid, @RequestParam String openCode,@RequestParam LoginAccountCategory loginAccountCategory);
    @RequestMapping(value = "/api/v1/account/findAccountBy", method = RequestMethod.GET)
    @Override
    UcLoginAccount findAccountBy(@RequestParam String userid,@RequestParam LoginAccountCategory category,@RequestParam String openCode);
}
