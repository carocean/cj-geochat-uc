package cj.geochat.middle.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.util.GeochatException;
import cj.geochat.middle.uc.AppDetails;
import cj.geochat.middle.uc.surface.IAppDetailsSurface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/app/details")
@Api(description = "应用信息查寻")
public class AppDetailsRestfull implements IAppDetailsRestfull {
    @Autowired
    IAppDetailsSurface appDetailsSurface;

    @GetMapping("/loadAppByAppKey")
    @ApiResult
    @ApiOperation("按指定appKey装载应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),@ApiResponse(responseCode = "4004", description = "AppKey:eeee does not exist.")})
    @Override
    public AppDetails loadAppByAppKey(String appKey) throws GeochatException {
        return appDetailsSurface.loadAppByAppKey(appKey);
    }

}
