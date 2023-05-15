package cj.geochat.open.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.open.uc.remote.RegisterUserRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/app")
@Api(description = "用户注册")
public class UserRegisterRestfull implements IUserRegisterRestfull {
    @Autowired
    RegisterUserRemote registerUserRemote;

    @GetMapping("/registerUser")
    @ApiResult
    @ApiOperation("用户注册")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String registerUser(String avatar, String nickName, String loginAccountCategory, String openCode, String password, String countryCode, String countryName, boolean isAgreeUPA) {
        return registerUserRemote.registerUser(avatar, nickName, loginAccountCategory, openCode, password, countryCode, countryName, isAgreeUPA);
    }

    @GetMapping("/registerUserByWechat")
    @ApiResult
    @ApiOperation("通用微信注册")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String registerUserByWechat(String avatar, String nickName, String openid, @RequestParam(required = false) String city, @RequestParam(required = false) String province, @RequestParam(required = false) String countryCode, @RequestParam(required = false) String countryName, @RequestParam(required = false) String language, int sex) {
        return registerUserRemote.registerUserByWechat(avatar, nickName, openid, city, province, countryCode, countryName, language, sex);
    }

    @GetMapping("/registerUserByAlipay")
    @ApiResult
    @ApiOperation("通用支付宝注册")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String registerUserByAlipay(String avatar, String nickName, String openid, @RequestParam(required = false) String city, @RequestParam(required = false) String province, String countryCode, @RequestParam(required = false) String countryName, @RequestParam(required = false) String gender) {
        return registerUserRemote.registerUserByAlipay(avatar, nickName, openid, city, province, countryCode, countryName, gender);
    }
}
