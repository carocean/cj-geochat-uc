package cj.geochat.uc.iapp.remote;

import cj.geochat.uc.middle.GenderType;
import cj.geochat.uc.middle.model.UcUser;
import cj.geochat.uc.middle.web.rest.IUserRestfull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "userRemote", value = "cj-geochat-uc-middle", url = "${app.test.feign.adapter.docker.uc.url:}")
public interface UserRemote extends IUserRestfull {
    @RequestMapping(value = "/api/v1/user/getUser", method = RequestMethod.GET)
    @Override
    UcUser getUser(@RequestParam String userId);

    @RequestMapping(value = "/api/v1/user/updatePwd", method = RequestMethod.GET)
    @Override
    void updatePwd(@RequestParam String userId, @RequestParam String pwd);

    @RequestMapping(value = "/api/v1/user/updateAvatar", method = RequestMethod.GET)
    @Override
    void updateAvatar(@RequestParam String userId, @RequestParam String avatar);

    @RequestMapping(value = "/api/v1/user/updateInfo", method = RequestMethod.GET)
    @Override
    void updateInfo(@RequestParam String userId, @RequestParam String realName, @RequestParam String email, @RequestParam String phone);

    @RequestMapping(value = "/api/v1/user/updateNickName", method = RequestMethod.GET)
    @Override
    void updateNickName(@RequestParam String userId, @RequestParam String nickName);

    @RequestMapping(value = "/api/v1/user/updateIntro", method = RequestMethod.GET)
    @Override
    void updateIntro(@RequestParam String userId, @RequestParam String intro);

    @RequestMapping(value = "/api/v1/user/updateMajorAccount", method = RequestMethod.GET)
    @Override
    void updateMajorAccount(@RequestParam String userId, @RequestParam String accountId);

    @RequestMapping(value = "/api/v1/user/updateRealName", method = RequestMethod.GET)
    @Override
    void updateRealName(@RequestParam String userid, @RequestParam String realName);

    @RequestMapping(value = "/api/v1/user/updateGender", method = RequestMethod.GET)
    @Override
    void updateGender(@RequestParam String userid, @RequestParam GenderType gender);

    @RequestMapping(value = "/api/v1/user/updateCountry", method = RequestMethod.GET)
    @Override
    void updateCountry(@RequestParam String userid, @RequestParam String countryCode, @RequestParam(required = false) String countryName);
}
