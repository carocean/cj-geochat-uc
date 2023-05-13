package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.LoggerEventType;
import cj.geochat.middle.uc.model.SysLoggerEvent;

import java.util.List;

public interface ISysLoggerEventService {
    void logger(SysLoggerEvent loggerEvent);

    void remove(String beginTime, String endTime);

    List<SysLoggerEvent> listLogger(long limit, long offset);

    List<SysLoggerEvent> listLoggerByUser(String userId, long limit, long offset);

    List<SysLoggerEvent> listLoggerByType(LoggerEventType eventType, long limit, long offset);

    List<SysLoggerEvent> listLoggerByTime(String beginTime, String endTime, long limit, long offset);

    SysLoggerEvent getLogger(String id);


}
