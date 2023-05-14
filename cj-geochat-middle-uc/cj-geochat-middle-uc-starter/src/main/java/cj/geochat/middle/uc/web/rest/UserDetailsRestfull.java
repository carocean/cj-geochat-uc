package cj.geochat.middle.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.UserDetails;
import cj.geochat.middle.uc.surface.IUserDetailsSurface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user/details")
@Api(description = "用户详细信息")
public class UserDetailsRestfull implements IUserDetailsRestfull {
    @Autowired
    IUserDetailsSurface userDetailsSurface;

    @GetMapping("/loadUserDetails")
    @ApiResult
    @ApiOperation("获取指定用户详细信息")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UserDetails loadUserDetails(String userId) {
        return userDetailsSurface.loadUserDetails(userId);
    }

    @GetMapping("/loadUserDetailsByAccount")
    @ApiResult
    @ApiOperation("根据账号获取账号信息")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UserDetails loadUserDetailsByAccount(LoginAccountCategory category, String openCode) {
        return userDetailsSurface.loadUserDetailsByAccount(category, openCode);
    }
}
