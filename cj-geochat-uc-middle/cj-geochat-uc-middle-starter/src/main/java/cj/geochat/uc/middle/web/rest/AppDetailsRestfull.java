package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.util.GeochatException;
import cj.geochat.uc.middle.AppDetails;
import cj.geochat.uc.middle.surface.IAppDetailsSurface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/app/details")
@Tag(name = "应用信息查寻")
public class AppDetailsRestfull implements IAppDetailsRestfull {
    @Autowired
    IAppDetailsSurface appDetailsSurface;

    @GetMapping("/loadAppByAppKey")
    @ApiResult
    @Operation(summary = "按指定appKey装载应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),@ApiResponse(responseCode = "4004", description = "AppKey:eeee does not exist.")})
    @Override
    public AppDetails loadAppByAppKey(String appKey) throws GeochatException {
        return appDetailsSurface.loadAppByAppKey(appKey);
    }

}
