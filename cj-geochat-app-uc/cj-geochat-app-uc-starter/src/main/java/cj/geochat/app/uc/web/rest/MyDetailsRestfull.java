package cj.geochat.app.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.oauth2.app.DefaultAppAuthentication;
import cj.geochat.ability.oauth2.app.DefaultAppPrincipal;
import cj.geochat.app.uc.framework.rest.IMyDetailsRestfull;
import cj.geochat.app.uc.remote.UserDetailsRemote;
import cj.geochat.middle.uc.UserDetails;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/details")
@Api(description = "我的信息",tags = "我的信息")
public class MyDetailsRestfull implements IMyDetailsRestfull {
    @Autowired
    UserDetailsRemote userDetailsRemote;

    @GetMapping("/getMyDetails")
    @ApiResult
    @ApiOperation("获取我的信息")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UserDetails getMyDetails() {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return userDetailsRemote.loadUserDetails(principal.getUserid());
    }
}
