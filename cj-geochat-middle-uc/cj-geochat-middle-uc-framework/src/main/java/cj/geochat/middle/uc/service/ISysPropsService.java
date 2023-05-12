package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.model.SysProps;

import java.util.List;

public interface ISysPropsService {

    void removeProperty(String id);

    void removeProperty(String map, String key);

    void putProperty(String map, String key, String value, String note);

    SysProps getProperty(String id);

    SysProps getProperty(String map, String key);

    List<SysProps> listProperty(int limit, long offset);

    List<SysProps> listMap(String map);

    void emptyMap(String map);

}
