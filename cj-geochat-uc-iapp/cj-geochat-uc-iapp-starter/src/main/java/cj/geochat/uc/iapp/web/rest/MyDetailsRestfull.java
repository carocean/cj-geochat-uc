package cj.geochat.uc.iapp.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.oauth.app.principal.DefaultAppAuthentication;
import cj.geochat.ability.oauth.app.principal.DefaultAppPrincipal;
import cj.geochat.uc.iapp.framework.rest.IMyDetailsRestfull;
import cj.geochat.uc.iapp.remote.UserDetailsRemote;
import cj.geochat.uc.middle.UserDetails;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/details")
@Tag(name = "我的信息")
public class MyDetailsRestfull implements IMyDetailsRestfull {
    @Autowired
    UserDetailsRemote userDetailsRemote;

    @GetMapping("/getMyDetails")
    @ApiResult
    @Operation(summary = "获取我的信息")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UserDetails getMyDetails() {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return userDetailsRemote.loadUserDetails(principal.getName());
    }
}
