package cj.geochat.app.uc.framework.rest;

import cj.geochat.middle.uc.model.UcUserDevice;

import java.util.List;

public interface IMyDeviceRestfull {
    String createDevice(String identifier, String osName, String deviceName, String deviceVersion);

    UcUserDevice findDevice(String identifier);

    List<UcUserDevice> listDeviceOfUser();

    void removeDeviceOfUser(String identifier);

    void emptyDeviceOfUser();
}
