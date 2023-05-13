package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.model.AppResourceId;

import java.util.List;

public interface IAppResourceIdService {
    String createResource(String code, String title, String desc);

    void removeResource(String id);

    AppResourceId getResource(String id);

    List<AppResourceId> listResource();

    List<String> listAllResourceCode();

    void addResourceIdToApp(String resourceId, String appId);

    void removeResourceIdFromApp(String resourceId, String appId);

    List<String> listResourceCode(String appId);

}
