package cj.geochat.proxy.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.proxy.uc.remote.UcAuthRemote;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/app/auth")
@Api(description = "认证服务。接收认证中心的回调(授权码和简化模式")
public class UserAuthRestfull implements IUserLoginRestfull {
    @Autowired
    UcAuthRemote authRemote;

    @Value("${app.security.appKey}")
    String appKey;
    @Value("${app.security.appSecret}")
    String appSecret;
    @Value("${app.security.scopes}")
    String scopes;

    @PostMapping("/authorization_code")
    @ApiResult
    @ApiOperation("以授权码模式登录")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String authorization_code(String username, String password) throws IOException {
        feign.Response response = authRemote.login(username, password);
        byte[] data = readFully(response.body().asInputStream());
        return new String(data);
    }

    @PostMapping("/implicit")
    @ApiResult
    @ApiOperation("以简化模式登录")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String implicit(String username, String password) throws IOException {
        feign.Response response = authRemote.login(username, password);
        byte[] data = readFully(response.body().asInputStream());
        return new String(data);
    }

    @PostMapping("/password")
    @ApiResult
    @ApiOperation("以密码模式登录")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String password(String username, String password) throws IOException {
        feign.Response response = authRemote.tokenPassword("password", username, password, appKey, appSecret, scopes);
        byte[] data = readFully(response.body().asInputStream());
        return new String(data);
    }

    @PostMapping("/sms_code")
    @ApiResult
    @ApiOperation("以短信验证码模式登录")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String sms_code(String phone_num, String sms_code) throws IOException {
        feign.Response response = authRemote.tokenSmsCode("sms_code", phone_num, sms_code, appKey, appSecret, scopes);
        byte[] data = readFully(response.body().asInputStream());
        return new String(data);
    }

    @PostMapping("/refresh_token")
    @ApiResult
    @ApiOperation("刷新令牌")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String refresh_token(String refresh_token) throws IOException {
        feign.Response response = authRemote.refreshToken("refresh_token", appKey, appSecret, refresh_token);
        byte[] data = readFully(response.body().asInputStream());
        return new String(data);
    }
}
