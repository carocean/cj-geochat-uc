package cj.geochat.middle.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.model.Application;
import cj.geochat.middle.uc.service.IApplicationService;
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
@RequestMapping("/api/v1/application")
@Api(description = "应用管理")
public class ApplicationRestfull implements IApplicationRestfull {
    @Autowired
    IApplicationService applicationService;

    @GetMapping("/createApp")
    @ApiResult
    @ApiOperation("新建应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createApp(String appName, String appTypeId, String appCategoryId, @RequestParam(required = false) String additionalInformation) {
        return applicationService.createApp(appName, appTypeId, appCategoryId, additionalInformation);
    }

    @GetMapping("/removeApp")
    @ApiResult
    @ApiOperation("移除应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeApp(String appId) {
        applicationService.removeApp(appId);
    }

    @GetMapping("/getApp")
    @ApiResult
    @ApiOperation("获取应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public Application getApp(String appId) {
        return applicationService.getApp(appId);
    }

    @GetMapping("/getAppByKey")
    @ApiResult
    @ApiOperation("通过appKey获取应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public Application getAppByKey(String appKey) {
        return applicationService.getAppByKey(appKey);
    }

    @GetMapping("/listApp")
    @ApiResult
    @ApiOperation("列出应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Application> listApp(long limit, long offset) {
        return applicationService.listApp(limit, offset);
    }

    @GetMapping("/listAppByType")
    @ApiResult
    @ApiOperation("通过应用类型列出应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Application> listAppByType(String appTypeId, long limit, long offset) {
        return applicationService.listAppByType(appTypeId, limit, offset);
    }

    @GetMapping("/listAppByCategory")
    @ApiResult
    @ApiOperation("通过应用类别列出应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<Application> listAppByCategory(String appCategoryId, long limit, long offset) {
        return applicationService.listAppByCategory(appCategoryId, limit, offset);
    }

    @GetMapping("/resetAppSecret")
    @ApiResult
    @ApiOperation("重置应用密钥")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void resetAppSecret(String appId) {
        applicationService.resetAppSecret(appId);
    }

    @GetMapping("/updateAccessTokenValidity")
    @ApiResult
    @ApiOperation("更新访问令牌有效时间")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateAccessTokenValidity(String appId, long intervalSeconds) {
        applicationService.updateAccessTokenValidity(appId, intervalSeconds);
    }

    @GetMapping("/updateRefreshTokenValidity")
    @ApiResult
    @ApiOperation("更新刷新令牌有效时间")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateRefreshTokenValidity(String appId, long intervalSeconds) {
        applicationService.updateRefreshTokenValidity(appId, intervalSeconds);
    }

    @GetMapping("/updateAutoapprove")
    @ApiResult
    @ApiOperation("更新是否需要用户授权确认")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateAutoapprove(String appId, boolean autoapprove) {
        applicationService.updateAutoapprove(appId, autoapprove);
    }

    @GetMapping("/updateAdditionalInformation")
    @ApiResult
    @ApiOperation("更新扩展信息，必须是json")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateAdditionalInformation(String appId, String additionalInformation) {
        applicationService.updateAdditionalInformation(appId, additionalInformation);
    }

    @GetMapping("/addGrantTypeToApp")
    @ApiResult
    @ApiOperation("添加授权类型到应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addGrantTypeToApp(String grantType, String appId) {
        applicationService.addGrantTypeToApp(grantType, appId);
    }

    @GetMapping("/removeGrantTypeFromApp")
    @ApiResult
    @ApiOperation("从应用移除授权类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeGrantTypeFromApp(String grantType, String appId) {
        applicationService.removeGrantTypeFromApp(grantType, appId);
    }

    @GetMapping("/listGrantType")
    @ApiResult
    @ApiOperation("列出授权类型")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listGrantType(String appId) {
        return applicationService.listGrantType(appId);
    }

    @GetMapping("/addRedirectUriToApp")
    @ApiResult
    @ApiOperation("为应用添加重定向")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addRedirectUriToApp(String redirectUri, String appId) {
        applicationService.addRedirectUriToApp(redirectUri, appId);
    }

    @GetMapping("/removeRedirectUriFromApp")
    @ApiResult
    @ApiOperation("移除重定向地址从应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeRedirectUriFromApp(String redirectUri, String appId) {
        applicationService.removeRedirectUriFromApp(redirectUri, appId);
    }

    @GetMapping("/listRedirectUri")
    @ApiResult
    @ApiOperation("列出应用的重定向地址")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listRedirectUri(String appId) {
        return applicationService.listRedirectUri(appId);
    }
}
