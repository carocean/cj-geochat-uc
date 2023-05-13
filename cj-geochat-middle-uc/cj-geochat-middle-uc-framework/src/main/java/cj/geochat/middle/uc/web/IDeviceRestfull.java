package cj.geochat.middle.uc.web;

import cj.geochat.middle.uc.model.UcDevice;

import java.util.List;

public interface IDeviceRestfull {
    void createDevice(String identifier, String osName, String deviceName, String deviceVersion);

    void removeDevice(String deviceId);

    UcDevice getDevice(String deviceId);

    UcDevice findDevice(String identifier);

    List<UcDevice> listDevice(int limit, long offset);

    List<UcDevice> listDeviceByOSName(String os_name, int limit, long offset);

    List<UcDevice> listDeviceOfUser(String userId);

    void removeDeviceOfUser(String deviceId, String userId);

    void emptyDeviceOfUser(String userId);

    void emptyUserOfDevice(String deviceId);

    void addDeviceToUser(String deviceId, String userId);
}
