package cj.geochat.uc.middle.service;

import cj.geochat.uc.middle.model.UcUserDevice;

import java.util.List;

public interface IUserDeviceService {
    String createDevice(String userId,String identifier, String osName, String deviceName, String deviceVersion);

    void removeDevice(String deviceId);

    UcUserDevice getDevice(String deviceId);

    UcUserDevice findDevice(String userId,String identifier);

    List<UcUserDevice> listDeviceOfUser(String userId);

    void removeDeviceOfUser(String userId,String identifier);

    void emptyDeviceOfUser(String userId);
}
