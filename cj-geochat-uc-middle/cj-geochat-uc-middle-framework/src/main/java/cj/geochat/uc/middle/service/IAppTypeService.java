package cj.geochat.uc.middle.service;

import cj.geochat.uc.middle.model.AppType;

import java.util.List;

public interface IAppTypeService {
    String createAppType(String code, String name, String desc);

    void removeAppType(String id);

    AppType getAppType(String id);

    List<AppType> listAppType();

}
