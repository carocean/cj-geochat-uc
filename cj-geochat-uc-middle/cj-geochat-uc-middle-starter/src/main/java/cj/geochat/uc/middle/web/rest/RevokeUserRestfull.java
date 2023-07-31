package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.surface.IRevokeUserSurface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "撤销用户")
public class RevokeUserRestfull implements IRevokeUserRestfull {
    @Autowired
    IRevokeUserSurface revokeUserSurface;

    @GetMapping("/revokeUser")
    @ApiResult
    @Operation(summary = "撤销指定的用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void revokeUser(String userId) {
        revokeUserSurface.revokeUser(userId);
    }
}
