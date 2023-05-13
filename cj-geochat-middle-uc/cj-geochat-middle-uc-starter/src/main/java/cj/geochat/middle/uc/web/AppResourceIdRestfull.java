package cj.geochat.middle.uc.web;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.model.AppResourceId;
import cj.geochat.middle.uc.service.IAppResourceIdService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/app/resourceid")
@Api(description = "应用资源管理")
public class AppResourceIdRestfull implements IAppResourceIdRestfull {
    @Autowired
    IAppResourceIdService resourceIdService;

    @GetMapping("/createResource")
    @ApiResult
    @ApiOperation("新建资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createResource(String code, String title, String desc) {
        return resourceIdService.createResource(code, title, desc);
    }

    @GetMapping("/removeResource")
    @ApiResult
    @ApiOperation("移除资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeResource(String id) {
        resourceIdService.removeResource(id);
    }

    @GetMapping("/getResource")
    @ApiResult
    @ApiOperation("获取资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public AppResourceId getResource(String id) {
        return resourceIdService.getResource(id);
    }

    @GetMapping("/listResource")
    @ApiResult
    @ApiOperation("列出资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<AppResourceId> listResource() {
        return resourceIdService.listResource();
    }

    @GetMapping("/listAllResourceCode")
    @ApiResult
    @ApiOperation("列出所有资源标识")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listAllResourceCode() {
        return resourceIdService.listAllResourceCode();
    }

    @GetMapping("/addResourceIdToApp")
    @ApiResult
    @ApiOperation("添加资源到应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addResourceIdToApp(String resourceId, String appId) {
        resourceIdService.addResourceIdToApp(resourceId, appId);
    }

    @GetMapping("/removeResourceIdFromApp")
    @ApiResult
    @ApiOperation("移除资源从应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeResourceIdFromApp(String resourceId, String appId) {
        resourceIdService.removeResourceIdFromApp(resourceId, appId);
    }

    @GetMapping("/listResourceCode")
    @ApiResult
    @ApiOperation("列出应用资源")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listResourceCode(String appId) {
        return resourceIdService.listResourceCode(appId);
    }
}
