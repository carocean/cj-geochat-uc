package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.model.AppCapability;
import cj.geochat.uc.middle.service.IAppCapabilityService;
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
@RequestMapping("/api/v1/app/capability")
@Tag(name = "应用能力管理")
public class AppCapabilityRestfull implements IAppCapabilityRestfull {
    @Autowired
    IAppCapabilityService capabilityService;

    @GetMapping("/createCapability")
    @ApiResult
    @Operation(summary = "新建应用能力")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createCapability(String code, String name, int order, @RequestParam(required = false) String desc) {
        return capabilityService.createCapability(code, name, order, desc);
    }

    @GetMapping("/removeCapability")
    @ApiResult
    @Operation(summary = "移除应用能力")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeCapability(String id) {
        capabilityService.removeCapability(id);
    }

    @GetMapping("/getCapability")
    @ApiResult
    @Operation(summary = "获取应用能力")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public AppCapability getCapability(String id) {
        return capabilityService.getCapability(id);
    }

    @GetMapping("/listCapability")
    @ApiResult
    @Operation(summary = "列出应用能力")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<AppCapability> listCapability() {
        return capabilityService.listCapability();
    }

    @GetMapping("/updateOrder")
    @ApiResult
    @Operation(summary = "更新应用能力顺序")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateOrder(String id, int order) {
        capabilityService.updateOrder(id, order);
    }

    @GetMapping("/addCapabilityToApp")
    @ApiResult
    @Operation(summary = "添加应用能力到指定应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addCapabilityToApp(String abilityId, String appId) {
        capabilityService.addCapabilityToApp(abilityId, appId);
    }

    @GetMapping("/removeCapabilityFromApp")
    @ApiResult
    @Operation(summary = "移除应用的应用能力")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeCapabilityFromApp(String abilityId, String appId) {
        capabilityService.removeCapabilityFromApp(abilityId, appId);
    }

    @GetMapping("/listCapabilityCodeOfApp")
    @ApiResult
    @Operation(summary = "列出指定应用的应用能力")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listCapabilityCodeOfApp(String appId) {
        return capabilityService.listCapabilityCodeOfApp(appId);
    }
}
