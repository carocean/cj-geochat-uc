package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.model.SysLoggerRegister;

import java.util.List;

public interface ILoggerRegisterService {
    void addLogger(SysLoggerRegister loggerRegister);

    void removeLogger(String beginTime, String endTime);

    SysLoggerRegister getLogger(String id);

    List<SysLoggerRegister> listLogger(int limit, long offset);

    List<SysLoggerRegister> listLogger(String beginTime, String endTime, int limit, long offset);

    List<SysLoggerRegister> listLoggerByEventType(String eventType, int limit, long offset);

    List<SysLoggerRegister> listLoggerByUser(String userId, int limit, long offset);

    List<SysLoggerRegister> listLoggerByUser(String userId, String status, int limit, long offset);

    List<SysLoggerRegister> listLoggerByStatus(String status, int limit, long offset);
}
