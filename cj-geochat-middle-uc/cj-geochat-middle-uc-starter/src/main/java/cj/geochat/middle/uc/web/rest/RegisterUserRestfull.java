package cj.geochat.middle.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.surface.IRegisterUserSurface;
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
@RequestMapping("/api/v1/register")
@Api(description = "用户注册入口")
public class RegisterUserRestfull implements IRegisterUserRestfull {
    @Autowired
    IRegisterUserSurface registerUserSurface;

    @GetMapping("/registerUser")
    @ApiResult
    @ApiOperation("注册用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),
            @ApiResponse(responseCode = "5000", description = "this openCode has been registered by others")})
    @Override
    public String registerUser(String avatar, String nickName, String loginAccountCategory, String openCode, String password, @RequestParam(required = false) String countryCode, @RequestParam(required = false) String countryName, boolean isAgreeUPA) {
        return registerUserSurface.registerUser(avatar, nickName, loginAccountCategory, openCode, password, countryCode, countryName, isAgreeUPA);
    }

    @GetMapping("/registerUserByWechat")
    @ApiResult
    @ApiOperation("通过微信注册")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),
            @ApiResponse(responseCode = "5000", description = "this openid has been registered by others")})
    @Override
    public String registerUserByWechat(String avatar, String nickName, String openid, @RequestParam(required = false) String city, @RequestParam(required = false) String province, @RequestParam(required = false) String countryCode, @RequestParam(required = false) String countryName, @RequestParam(required = false) String language, int sex) {
        return registerUserSurface.registerUserByWechat(avatar, nickName, openid, city, province, countryCode, countryName, language, sex);
    }

    @GetMapping("/registerUserByAlipay")
    @ApiResult
    @ApiOperation("通过支付宝注册")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),
            @ApiResponse(responseCode = "5000", description = "this openid has been registered by others")})
    @Override
    public String registerUserByAlipay(String avatar, String nickName, String openid, @RequestParam(required = false) String city, @RequestParam(required = false) String province, @RequestParam(required = false) String countryCode, @RequestParam(required = false) String countryName, String gender) {
        return registerUserSurface.registerUserByAlipay(avatar, nickName, openid, city, province, countryCode, countryName, gender);
    }
}
