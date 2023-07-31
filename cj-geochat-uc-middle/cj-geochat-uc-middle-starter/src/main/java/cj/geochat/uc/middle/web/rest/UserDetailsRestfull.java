package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.LoginAccountCategory;
import cj.geochat.uc.middle.UserDetails;
import cj.geochat.uc.middle.surface.IUserDetailsSurface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/details")
@Tag(name = "用户详细信息")
public class UserDetailsRestfull implements IUserDetailsRestfull {
    @Autowired
    IUserDetailsSurface userDetailsSurface;

    @GetMapping("/loadUserDetails")
    @ApiResult
    @Operation(summary = "获取指定用户详细信息")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UserDetails loadUserDetails(String userId) {
        return userDetailsSurface.loadUserDetails(userId);
    }

    @GetMapping("/loadUserDetailsByAccount")
    @ApiResult
    @Operation(summary = "根据账号获取账号信息")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UserDetails loadUserDetailsByAccount(LoginAccountCategory category, String openCode) {
        return userDetailsSurface.loadUserDetailsByAccount(category, openCode);
    }
}
