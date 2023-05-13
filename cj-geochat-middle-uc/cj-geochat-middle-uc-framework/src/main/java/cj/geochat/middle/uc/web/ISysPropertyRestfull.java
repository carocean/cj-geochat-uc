package cj.geochat.middle.uc.web;

import cj.geochat.middle.uc.model.SysProps;

import java.util.List;

public interface ISysPropertyRestfull {

    void removeById(String id);

    void remove(String map, String key);

    void put(String map, String key, String value, String note);

    SysProps getPropertyById(String id);

    SysProps getProperty(String map, String key);

    String getValue(String map, String key);

    String getNote(String map, String key);
    List<SysProps> listProperty(int limit, long offset);

    List<SysProps> listByMap(String map);

    void emptyMap(String map);
}
