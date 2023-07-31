package cj.geochat.uc.iapp.remote;

import cj.geochat.uc.middle.model.UcUserDevice;
import cj.geochat.uc.middle.web.rest.IUserDeviceRestfull;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(contextId = "userDeviceRemote", value = "cj-geochat-uc-middle", url = "${app.test.feign.adapter.docker.uc.url:}")
public interface UserDeviceRemote extends IUserDeviceRestfull {
    @RequestMapping(value = "/api/v1/user/device/createDevice", method = RequestMethod.GET)
    @Override
    String createDevice(@RequestParam String userId, @RequestParam String identifier, @RequestParam(required = false) String osName, @RequestParam(required = false) String deviceName, @RequestParam(required = false) String deviceVersion);

    @RequestMapping(value = "/api/v1/user/device/removeDevice", method = RequestMethod.GET)
    @Override
    void removeDevice(@RequestParam String deviceId);

    @RequestMapping(value = "/api/v1/user/device/getDevice", method = RequestMethod.GET)
    @Override
    UcUserDevice getDevice(@RequestParam String deviceId);

    @RequestMapping(value = "/api/v1/user/device/findDevice", method = RequestMethod.GET)
    @Override
    UcUserDevice findDevice(@RequestParam String userId, @RequestParam String identifier);

    @RequestMapping(value = "/api/v1/user/device/listDeviceOfUser", method = RequestMethod.GET)
    @Override
    List<UcUserDevice> listDeviceOfUser(@RequestParam String userId);

    @RequestMapping(value = "/api/v1/user/device/removeDevice", method = RequestMethod.GET)
    @Override
    void removeDeviceOfUser(@RequestParam String userId, @RequestParam String identifier);

    @RequestMapping(value = "/api/v1/user/device/emptyDeviceOfUser", method = RequestMethod.GET)
    @Override
    void emptyDeviceOfUser(@RequestParam String userId);
}
