package cj.geochat.middle.uc.web;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.model.AppType;
import cj.geochat.middle.uc.service.IAppTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/app/type")
@Api(description = "应用类型管理")
public class AppTypeRestfull implements IAppTypeRestfull {
    @Autowired
    IAppTypeService typeService;

    @GetMapping("/createAppType")
    @ApiResult
    @ApiOperation("新建应用类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createAppType(String code, String name, @RequestParam(required = false) String desc) {
        return typeService.createAppType(code, name, desc);
    }

    @GetMapping("/removeAppType")
    @ApiResult
    @ApiOperation("移除应用类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAppType(String id) {
        typeService.removeAppType(id);
    }

    @GetMapping("/getAppType")
    @ApiResult
    @ApiOperation("获取应用类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public AppType getAppType(String id) {
        return typeService.getAppType(id);
    }

    @GetMapping("/listAppType")
    @ApiResult
    @ApiOperation("列出应用类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<AppType> listAppType() {
        return typeService.listAppType();
    }
}
