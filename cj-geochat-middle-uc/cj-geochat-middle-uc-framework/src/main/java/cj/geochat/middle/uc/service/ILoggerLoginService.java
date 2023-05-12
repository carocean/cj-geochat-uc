package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.model.SysLoggerLogin;

import java.util.List;

public interface ILoggerLoginService {
    void addLogger(SysLoggerLogin loggerLogin);

    void removeLogger(String beginTime, String endTime);

    SysLoggerLogin getLogger(String id);

    List<SysLoggerLogin> listLogger(int limit, long offset);
    List<SysLoggerLogin> listLogger(String beginTime, String endTime, int limit, long offset);
    List<SysLoggerLogin> listLoggerByEventType(String eventType, int limit, long offset);

    List<SysLoggerLogin> listLoggerByUser(String userId, int limit, long offset);

    List<SysLoggerLogin> listLoggerByUser(String userId, String status, int limit, long offset);

    List<SysLoggerLogin> listLoggerByStatus(String status, int limit, long offset);
}
