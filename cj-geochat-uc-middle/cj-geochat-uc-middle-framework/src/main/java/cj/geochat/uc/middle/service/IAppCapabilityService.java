package cj.geochat.uc.middle.service;

import cj.geochat.uc.middle.model.AppCapability;

import java.util.List;

public interface IAppCapabilityService {
    String createCapability(String code,String name,int order,String desc);

    void removeCapability(String id);

    AppCapability getCapability(String id);

    List<AppCapability> listCapability();

    void updateOrder(String id, int order);

    void addCapabilityToApp(String abilityId,String appId);

    void removeCapabilityFromApp(String abilityId,String appId);


    List<String> listCapabilityCodeOfApp(String appId);
}
