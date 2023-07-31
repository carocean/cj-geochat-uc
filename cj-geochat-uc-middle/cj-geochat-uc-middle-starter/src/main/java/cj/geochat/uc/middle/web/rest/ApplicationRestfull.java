package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.model.Application;
import cj.geochat.uc.middle.service.IApplicationService;
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
@RequestMapping("/api/v1/application")
@Tag(name = "应用管理")
public class ApplicationRestfull implements IApplicationRestfull {
    @Autowired
    IApplicationService applicationService;

    @GetMapping("/createApp")
    @ApiResult
    @Operation(summary = "新建应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createApp(String appName, String appTypeId, String appCategoryId, @RequestParam(required = false) String additionalInformation) {
        return applicationService.createApp(appName, appTypeId, appCategoryId, additionalInformation);
    }

    @GetMapping("/removeApp")
    @ApiResult
    @Operation(summary = "移除应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeApp(String appId) {
        applicationService.removeApp(appId);
    }

    @GetMapping("/getApp")
    @ApiResult
    @Operation(summary = "获取应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public Application getApp(String appId) {
        return applicationService.getApp(appId);
    }

    @GetMapping("/getAppByKey")
    @ApiResult
    @Operation(summary = "通过appKey获取应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public Application getAppByKey(String appKey) {
        return applicationService.getAppByKey(appKey);
    }

    @GetMapping("/listApp")
    @ApiResult
    @Operation(summary = "列出应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Application> listApp(long limit, long offset) {
        return applicationService.listApp(limit, offset);
    }

    @GetMapping("/listAppByType")
    @ApiResult
    @Operation(summary = "通过应用类型列出应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Application> listAppByType(String appTypeId, long limit, long offset) {
        return applicationService.listAppByType(appTypeId, limit, offset);
    }

    @GetMapping("/listAppByCategory")
    @ApiResult
    @Operation(summary = "通过应用类别列出应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Application> listAppByCategory(String appCategoryId, long limit, long offset) {
        return applicationService.listAppByCategory(appCategoryId, limit, offset);
    }

    @GetMapping("/resetAppSecret")
    @ApiResult
    @Operation(summary = "重置应用密钥")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void resetAppSecret(String appId) {
        applicationService.resetAppSecret(appId);
    }

    @GetMapping("/updateAccessTokenValidity")
    @ApiResult
    @Operation(summary = "更新访问令牌有效时间")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateAccessTokenValidity(String appId, long intervalSeconds) {
        applicationService.updateAccessTokenValidity(appId, intervalSeconds);
    }

    @GetMapping("/updateRefreshTokenValidity")
    @ApiResult
    @Operation(summary = "更新刷新令牌有效时间")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateRefreshTokenValidity(String appId, long intervalSeconds) {
        applicationService.updateRefreshTokenValidity(appId, intervalSeconds);
    }

    @GetMapping("/updateAutoapprove")
    @ApiResult
    @Operation(summary = "更新是否需要用户授权确认")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateAutoapprove(String appId, boolean autoapprove) {
        applicationService.updateAutoapprove(appId, autoapprove);
    }

    @GetMapping("/updateAdditionalInformation")
    @ApiResult
    @Operation(summary = "更新扩展信息，必须是json")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateAdditionalInformation(String appId, String additionalInformation) {
        applicationService.updateAdditionalInformation(appId, additionalInformation);
    }

    @GetMapping("/addGrantTypeToApp")
    @ApiResult
    @Operation(summary = "添加授权类型到应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addGrantTypeToApp(String grantType, String appId) {
        applicationService.addGrantTypeToApp(grantType, appId);
    }

    @GetMapping("/removeGrantTypeFromApp")
    @ApiResult
    @Operation(summary = "从应用移除授权类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeGrantTypeFromApp(String grantType, String appId) {
        applicationService.removeGrantTypeFromApp(grantType, appId);
    }

    @GetMapping("/listGrantType")
    @ApiResult
    @Operation(summary = "列出授权类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listGrantType(String appId) {
        return applicationService.listGrantType(appId);
    }

    @GetMapping("/addRedirectUriToApp")
    @ApiResult
    @Operation(summary = "为应用添加重定向")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addRedirectUriToApp(String redirectUri, String appId) {
        applicationService.addRedirectUriToApp(redirectUri, appId);
    }

    @GetMapping("/removeRedirectUriFromApp")
    @ApiResult
    @Operation(summary = "移除重定向地址从应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeRedirectUriFromApp(String redirectUri, String appId) {
        applicationService.removeRedirectUriFromApp(redirectUri, appId);
    }

    @GetMapping("/listRedirectUri")
    @ApiResult
    @Operation(summary = "列出应用的重定向地址")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listRedirectUri(String appId) {
        return applicationService.listRedirectUri(appId);
    }
}
