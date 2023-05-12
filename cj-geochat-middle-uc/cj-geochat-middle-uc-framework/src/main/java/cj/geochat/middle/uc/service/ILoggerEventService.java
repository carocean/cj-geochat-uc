package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.model.SysLoggerEvent;

import java.util.List;

public interface ILoggerEventService {
    void addLogger(SysLoggerEvent loggerEvent);

    void removeLogger(String beginTime, String endTime);

    SysLoggerEvent getLogger(String id);
    List<SysLoggerEvent> listLogger(int limit, long offset);
    List<SysLoggerEvent> listLogger(String beginTime, String endTime,int limit, long offset);

    List<SysLoggerEvent> listLoggerByEventType(String eventType, int limit, long offset);

    List<SysLoggerEvent> listLoggerByUser(String userId, int limit, long offset);

    List<SysLoggerEvent> listLoggerByUser(String userId, String status, int limit, long offset);

    List<SysLoggerEvent> listLoggerByStatus(String status, int limit, long offset);
}
