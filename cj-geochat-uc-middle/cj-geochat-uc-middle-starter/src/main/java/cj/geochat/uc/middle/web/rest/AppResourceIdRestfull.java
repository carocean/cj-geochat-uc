package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.model.AppResourceId;
import cj.geochat.uc.middle.service.IAppResourceIdService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/app/resourceid")
@Tag(name = "应用资源管理",description = "应用资源管理")
public class AppResourceIdRestfull implements IAppResourceIdRestfull {
    @Autowired
    IAppResourceIdService resourceIdService;

    @GetMapping("/createResource")
    @ApiResult
    @Operation(summary ="新建资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createResource(String code, String title, String desc) {
        return resourceIdService.createResource(code, title, desc);
    }

    @GetMapping("/removeResource")
    @ApiResult
    @Operation(summary = "移除资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeResource(String id) {
        resourceIdService.removeResource(id);
    }

    @GetMapping("/getResource")
    @ApiResult
    @Operation(summary = "获取资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public AppResourceId getResource(String id) {
        return resourceIdService.getResource(id);
    }

    @GetMapping("/listResource")
    @ApiResult
    @Operation(summary = "列出资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<AppResourceId> listResource() {
        return resourceIdService.listResource();
    }

    @GetMapping("/listAllResourceCode")
    @ApiResult
    @Operation(summary = "列出所有资源标识")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listAllResourceCode() {
        return resourceIdService.listAllResourceCode();
    }

    @GetMapping("/addResourceIdToApp")
    @ApiResult
    @Operation(summary = "添加资源到应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addResourceIdToApp(String resourceId, String appId) {
        resourceIdService.addResourceIdToApp(resourceId, appId);
    }

    @GetMapping("/removeResourceIdFromApp")
    @ApiResult
    @Operation(summary = "移除资源从应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeResourceIdFromApp(String resourceId, String appId) {
        resourceIdService.removeResourceIdFromApp(resourceId, appId);
    }

    @GetMapping("/listResourceCode")
    @ApiResult
    @Operation(summary = "列出应用资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listResourceCode(String appId) {
        return resourceIdService.listResourceCode(appId);
    }
}
