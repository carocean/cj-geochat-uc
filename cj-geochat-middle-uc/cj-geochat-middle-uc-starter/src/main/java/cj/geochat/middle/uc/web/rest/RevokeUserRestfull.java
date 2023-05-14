package cj.geochat.middle.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.surface.IRevokeUserSurface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Api(description = "撤销用户")
public class RevokeUserRestfull implements IRevokeUserRestfull {
    @Autowired
    IRevokeUserSurface revokeUserSurface;

    @GetMapping("/revokeUser")
    @ApiResult
    @ApiOperation("撤销指定的用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void revokeUser(String userId) {
        revokeUserSurface.revokeUser(userId);
    }
}
