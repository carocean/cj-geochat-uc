package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.model.UcUserDevice;
import cj.geochat.uc.middle.service.IUserDeviceService;
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
@RequestMapping("/api/v1/user/device")
@Tag(name = "用户设备管理")
public class UserDeviceRestfull implements IUserDeviceRestfull {
    @Autowired
    IUserDeviceService userDeviceService;

    @GetMapping("/createDevice")
    @ApiResult
    @Operation(summary = "新建设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createDevice(String userId, String identifier, String osName, @RequestParam(required = false) String deviceName, @RequestParam(required = false) String deviceVersion) {
        return userDeviceService.createDevice(userId, identifier, osName, deviceName, deviceVersion);
    }

    @GetMapping("/removeDevice")
    @ApiResult
    @Operation(summary = "移除设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeDevice(String deviceId) {
        userDeviceService.removeDevice(deviceId);
    }

    @GetMapping("/getDevice")
    @ApiResult
    @Operation(summary = "获取设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcUserDevice getDevice(String deviceId) {
        return userDeviceService.getDevice(deviceId);
    }

    @GetMapping("/findDevice")
    @ApiResult
    @Operation(summary = "查寻设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcUserDevice findDevice(String userId, String identifier) {
        return userDeviceService.findDevice(userId, identifier);
    }

    @GetMapping("/listDeviceOfUser")
    @ApiResult
    @Operation(summary = "列出用户的设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcUserDevice> listDeviceOfUser(String userId) {
        return userDeviceService.listDeviceOfUser(userId);
    }

    @GetMapping("/removeDeviceOfUser")
    @ApiResult
    @Operation(summary = "移除用户的指定设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeDeviceOfUser(String userId, String identifier) {
        userDeviceService.removeDeviceOfUser(userId, identifier);
    }

    @GetMapping("/emptyDeviceOfUser")
    @ApiResult
    @Operation(summary = "清空用户的所有设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void emptyDeviceOfUser(String userId) {
        userDeviceService.emptyDeviceOfUser(userId);
    }
}
