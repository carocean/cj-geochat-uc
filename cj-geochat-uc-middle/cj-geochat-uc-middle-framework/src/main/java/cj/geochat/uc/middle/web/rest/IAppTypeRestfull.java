package cj.geochat.uc.middle.web.rest;

import cj.geochat.uc.middle.model.AppType;

import java.util.List;

public interface IAppTypeRestfull {
    String createAppType(String code, String name, String desc);

    void removeAppType(String id);

    AppType getAppType(String id);

    List<AppType> listAppType();

}
