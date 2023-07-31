package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.model.AppType;
import cj.geochat.uc.middle.service.IAppTypeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/app/type")
@Tag(name = "应用类型管理")
public class AppTypeRestfull implements IAppTypeRestfull {
    @Autowired
    IAppTypeService typeService;

    @GetMapping("/createAppType")
    @ApiResult
    @Operation(summary = "新建应用类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createAppType(String code, String name, @RequestParam(required = false) String desc) {
        return typeService.createAppType(code, name, desc);
    }

    @GetMapping("/removeAppType")
    @ApiResult
    @Operation(summary = "移除应用类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAppType(String id) {
        typeService.removeAppType(id);
    }

    @GetMapping("/getAppType")
    @ApiResult
    @Operation(summary = "获取应用类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public AppType getAppType(String id) {
        return typeService.getAppType(id);
    }

    @GetMapping("/listAppType")
    @ApiResult
    @Operation(summary = "列出应用类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<AppType> listAppType() {
        return typeService.listAppType();
    }
}
