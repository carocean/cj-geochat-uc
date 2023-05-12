package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.model.UcDevice;

import java.util.List;

public interface IDeviceService {
    void addDevice(UcDevice device);

    void removeDevice(String deviceId);

    UcDevice getDevice(String deviceId);

    UcDevice findDevice(String identifier);

    List<UcDevice> listDevice(int limit, long offset);

    List<UcDevice> listDevice(String os_name, int limit, long offset);

    List<UcDevice> listDeviceOfUser(String userId);

    void removeDeviceOfUser(String deviceId, String userId);

    void emptyDeviceOfUser(String userId);

    void emptyUserOfDevice(String deviceId);

    void addDeviceToUser(String deviceId, String userId);
}
