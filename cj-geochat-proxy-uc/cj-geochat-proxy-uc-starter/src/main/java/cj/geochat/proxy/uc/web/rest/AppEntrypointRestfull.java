package cj.geochat.proxy.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/app")
@Api(description = "应用入口点。接收认证中心的回调(授权码和简化模式")
public class AppEntrypointRestfull implements IAppEntrypointRestfull {
    @PostMapping("/entrypoint")
    @ApiResult
    @ApiOperation("应用入口点")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public Map<String, Object> entrypoint(HttpServletRequest request, HttpServletResponse response) {
        return null;
    }

}
