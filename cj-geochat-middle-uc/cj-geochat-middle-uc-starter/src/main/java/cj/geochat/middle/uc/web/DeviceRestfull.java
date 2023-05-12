package cj.geochat.middle.uc.web;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.model.UcDevice;
import cj.geochat.middle.uc.restful.IDeviceRestfull;
import cj.geochat.middle.uc.service.IDeviceService;
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
@RequestMapping("/api/v1/device")
@Api(description = "用户设备管理")
public class DeviceRestfull implements IDeviceRestfull {
    @Autowired
    IDeviceService deviceService;

    @GetMapping("/createDevice")
    @ApiResult
    @ApiOperation("新建设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void createDevice(String identifier, String osName, String deviceName, @RequestParam(required = false) String deviceVersion) {
        deviceService.createDevice(identifier, osName, deviceName, deviceVersion);
    }

    @GetMapping("/removeDevice")
    @ApiResult
    @ApiOperation("移除设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeDevice(String deviceId) {
        deviceService.removeDevice(deviceId);
    }

    @GetMapping("/getDevice")
    @ApiResult
    @ApiOperation("获取设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcDevice getDevice(String deviceId) {
        return deviceService.getDevice(deviceId);
    }

    @GetMapping("/findDevice")
    @ApiResult
    @ApiOperation("按指定设备标识符查找")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcDevice findDevice(String identifier) {
        return deviceService.findDevice(identifier);
    }

    @GetMapping("/listDevice")
    @ApiResult
    @ApiOperation("列出设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcDevice> listDevice(int limit, long offset) {
        return deviceService.listDevice(limit, offset);
    }

    @GetMapping("/listDeviceByOSName")
    @ApiResult
    @ApiOperation("按操作系统列出设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcDevice> listDeviceByOSName(String os_name, int limit, long offset) {
        return deviceService.listDevice(os_name, limit, offset);
    }

    @GetMapping("/listDeviceOfUser")
    @ApiResult
    @ApiOperation("列出指定用户的所有设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcDevice> listDeviceOfUser(String userId) {
        return deviceService.listDeviceOfUser(userId);
    }

    @GetMapping("/removeDeviceOfUser")
    @ApiResult
    @ApiOperation("移除用户的设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeDeviceOfUser(String deviceId, String userId) {
        deviceService.removeDeviceOfUser(deviceId, userId);
    }

    @GetMapping("/emptyDeviceOfUser")
    @ApiResult
    @ApiOperation("清空用户设备")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void emptyDeviceOfUser(String userId) {
        deviceService.emptyDeviceOfUser(userId);
    }

    @GetMapping("/emptyUserOfDevice")
    @ApiResult
    @ApiOperation("清空设备绑定的用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void emptyUserOfDevice(String deviceId) {
        deviceService.emptyUserOfDevice(deviceId);
    }

    @GetMapping("/addDeviceToUser")
    @ApiResult
    @ApiOperation("添加设备到用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addDeviceToUser(String deviceId, String userId) {
        deviceService.addDeviceToUser(deviceId, userId);
    }
}
