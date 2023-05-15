package cj.geochat.open.uc.web.rest;

import cj.geochat.open.uc.remote.UcAuthRemote;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/app")
@Api(description = "应用入口点。接收认证中心的回调(授权码")
public class AppEntrypointRestfull implements IAppEntrypointRestfull {
    @Autowired
    UcAuthRemote authRemote;
    @Value("${app.security.appKey}")
    String client_id;
    @Value("${app.security.appSecret}")
    String client_secret;
    @Value("${app.security.redirect_uri}")
    String redirect_uri;

    @GetMapping("/entrypoint")
//    @ApiResult
    @ApiOperation("应用入口点")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void entrypoint(HttpServletRequest request, HttpServletResponse response) throws IOException {
        if (request.getParameterMap().containsKey("code")) {
            //处理授权码模式
            String code = request.getParameter("code");
            String state = request.getParameter("state");
            feign.Response feignResponse = authRemote.tokenAuthorizationCode(
                    "authorization_code", code, client_id, client_secret, redirect_uri
            );
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(readFully(feignResponse.body().asInputStream()));
            outputStream.flush();
            return;
        }

        Map<String, String> map = new HashMap<>();
        map.put("code", "4004");
        map.put("message", "nope");
        map.put("data", "");
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        OutputStream outputStream = response.getOutputStream();
        outputStream.write(new ObjectMapper().writeValueAsBytes(map));
        outputStream.flush();
    }

}
