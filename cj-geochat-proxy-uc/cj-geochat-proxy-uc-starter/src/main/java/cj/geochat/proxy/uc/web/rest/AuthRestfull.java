package cj.geochat.proxy.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.proxy.uc.remote.UcAuthRemote;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/app/auth")
@Api(description = "认证服务")
public class AuthRestfull implements IAuthRestfull {
    @Autowired
    UcAuthRemote authRemote;
    @Value("${app.security.appKey}")
    String appKey;
    @Value("${app.security.appSecret}")
    String appSecret;
    @Value("${app.security.scopes}")
    String scopes;
    @Value("redirect_uri")
    String redirectUri;

    @GetMapping("/authorization_code")
    @ApiResult
    @ApiOperation("向认证中心申请授权码，必须先以授权码模式登录")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String authorizeAuthorizationCode(String state) throws IOException {
        feign.Response response = authRemote.authorize("code", appKey, scopes, redirectUri, state);
        byte[] data = readFully(response.body().asInputStream());
        String json = new String(data);
        Map<String, Object> obj = new ObjectMapper().readValue(json, HashMap.class);
        if (!obj.containsKey("code")) {
            return json;
        }
        return new ObjectMapper().writeValueAsString(obj.get("data"));
    }

    @GetMapping("/authorizeImplicit")
    @ApiResult
    @ApiOperation("简化模式向认证中心申请令牌,必须先以简化模式登录")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String authorizeImplicit(String state) throws IOException {
        feign.Response response = authRemote.authorize("token", appKey, scopes, redirectUri, state);
        byte[] data = readFully(response.body().asInputStream());
        String json = new String(data);
        Map<String, Object> obj = new ObjectMapper().readValue(json, HashMap.class);
        if (!obj.containsKey("code")) {
            return json;
        }
        return new ObjectMapper().writeValueAsString(obj.get("data"));
    }

    @PostMapping("/confirmAccess")
    @ApiResult
    @ApiOperation("用户授权确认")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String confirmAccess(boolean user_oauth_approval, boolean scope_all) throws IOException {
        feign.Response response = authRemote.confirmAccess(user_oauth_approval, scope_all);
        byte[] data = readFully(response.body().asInputStream());
        String json = new String(data);
        Map<String, Object> obj = new ObjectMapper().readValue(json, HashMap.class);
        if (!obj.containsKey("code")) {
            return json;
        }
        return new ObjectMapper().writeValueAsString(obj.get("data"));
    }

    @PostMapping("/tokenAuthorizationCode")
    @ApiResult
    @ApiOperation("以授权码换取令牌")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String tokenAuthorizationCode(String code) throws IOException {
        feign.Response response = authRemote.tokenAuthorizationCode("authorization_code", code, appKey, appSecret, redirectUri);
        byte[] data = readFully(response.body().asInputStream());
        String json = new String(data);
        Map<String, Object> obj = new ObjectMapper().readValue(json, HashMap.class);
        if (!obj.containsKey("code")) {
            return json;
        }
        return new ObjectMapper().writeValueAsString(obj.get("data"));
    }

    @GetMapping("/logout")
    @ApiResult
    @ApiOperation("退出")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String logout(String access_token) throws IOException {
        feign.Response response = authRemote.logout(access_token);
        byte[] data = readFully(response.body().asInputStream());
        String json = new String(data);
        Map<String, Object> obj = new ObjectMapper().readValue(json, HashMap.class);
        if (!obj.containsKey("code")) {
            return json;
        }
        return new ObjectMapper().writeValueAsString(obj.get("data"));
    }
}
