package cj.geochat.open.uc.remote;

import cj.geochat.middle.uc.web.rest.IRegisterUserRestfull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(contextId = "registerUserRemote", value = "cj-geochat-middle-uc", url = "${app.test.feign.adapter.docker.uc.url:}")
public interface RegisterUserRemote extends IRegisterUserRestfull {

    @RequestMapping(value = "/api/v1/register/registerUser", method = RequestMethod.GET)
    @Override
    String registerUser(
            @RequestParam String avatar,
            @RequestParam String nickName,
            @RequestParam String loginAccountCategory,
            @RequestParam String openCode,
            @RequestParam String password,
            @RequestParam(required = false) String countryCode,
            @RequestParam(required = false) String countryName,
            @RequestParam boolean isAgreeUPA);

    @RequestMapping(value = "/api/v1/register/registerUserByWechat", method = RequestMethod.GET)
    @Override
    String registerUserByWechat(
            @RequestParam String avatar,
            @RequestParam String nickName,
            @RequestParam String openid,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String province,
            @RequestParam(required = false) String countryCode,
            @RequestParam(required = false) String countryName,
            @RequestParam(required = false) String language,
            @RequestParam int sex);

    @RequestMapping(value = "/api/v1/register/registerUserByAlipay", method = RequestMethod.GET)
    @Override
    String registerUserByAlipay(
            @RequestParam String avatar,
            @RequestParam String nickName,
            @RequestParam String openid,
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String province,
            @RequestParam(required = false) String countryCode,
            @RequestParam(required = false) String countryName,
            @RequestParam(required = false) String gender);
}
