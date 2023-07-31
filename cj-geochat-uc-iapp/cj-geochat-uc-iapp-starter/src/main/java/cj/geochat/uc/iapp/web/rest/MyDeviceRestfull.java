package cj.geochat.uc.iapp.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.oauth.app.principal.DefaultAppAuthentication;
import cj.geochat.ability.oauth.app.principal.DefaultAppPrincipal;
import cj.geochat.uc.iapp.framework.rest.IMyDeviceRestfull;
import cj.geochat.uc.iapp.remote.UserDeviceRemote;
import cj.geochat.uc.middle.model.UcUserDevice;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/device")
@Tag(name = "我的设备")
public class MyDeviceRestfull implements IMyDeviceRestfull {
    @Autowired
    UserDeviceRemote deviceRemote;

    @GetMapping("/createDevice")
    @ApiResult
    @Operation(summary = "创建设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createDevice(String identifier, @RequestParam(required = false) String osName, @RequestParam(required = false) String deviceName, @RequestParam(required = false) String deviceVersion) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return deviceRemote.createDevice(principal.getName(), identifier, osName, deviceName, deviceVersion);
    }

    @GetMapping("/findDevice")
    @ApiResult
    @Operation(summary = "查寻设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcUserDevice findDevice(String identifier) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return deviceRemote.findDevice(principal.getName(), identifier);
    }

    @GetMapping("/listDeviceOfUser")
    @ApiResult
    @Operation(summary = "查寻设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcUserDevice> listDeviceOfUser() {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return deviceRemote.listDeviceOfUser(principal.getName());
    }

    @GetMapping("/removeDeviceOfUser")
    @ApiResult
    @Operation(summary = "移除设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeDeviceOfUser(String identifier) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        deviceRemote.removeDeviceOfUser(principal.getName(), identifier);
    }

    @GetMapping("/emptyDeviceOfUser")
    @ApiResult
    @Operation(summary = "清空我的所有设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void emptyDeviceOfUser() {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        deviceRemote.emptyDeviceOfUser(principal.getName());
    }
}
