package cj.geochat.app.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.oauth2.app.DefaultAppAuthentication;
import cj.geochat.ability.oauth2.app.DefaultAppPrincipal;
import cj.geochat.app.uc.framework.rest.IMyDeviceRestfull;
import cj.geochat.app.uc.remote.UserDeviceRemote;
import cj.geochat.middle.uc.model.UcUserDevice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/device")
@Api(description = "我的设备",tags = "我的设备")
public class MyDeviceRestfull implements IMyDeviceRestfull {
    @Autowired
    UserDeviceRemote deviceRemote;

    @GetMapping("/createDevice")
    @ApiResult
    @ApiOperation("创建设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createDevice(String identifier, @RequestParam(required = false) String osName, @RequestParam(required = false) String deviceName, @RequestParam(required = false) String deviceVersion) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return deviceRemote.createDevice(principal.getUserid(), identifier, osName, deviceName, deviceVersion);
    }

    @GetMapping("/findDevice")
    @ApiResult
    @ApiOperation("查寻设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcUserDevice findDevice(String identifier) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return deviceRemote.findDevice(principal.getUserid(), identifier);
    }

    @GetMapping("/listDeviceOfUser")
    @ApiResult
    @ApiOperation("查寻设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcUserDevice> listDeviceOfUser() {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return deviceRemote.listDeviceOfUser(principal.getUserid());
    }

    @GetMapping("/removeDeviceOfUser")
    @ApiResult
    @ApiOperation("移除设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeDeviceOfUser(String identifier) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        deviceRemote.removeDeviceOfUser(principal.getUserid(), identifier);
    }

    @GetMapping("/emptyDeviceOfUser")
    @ApiResult
    @ApiOperation("清空我的所有设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void emptyDeviceOfUser() {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        deviceRemote.emptyDeviceOfUser(principal.getUserid());
    }
}
