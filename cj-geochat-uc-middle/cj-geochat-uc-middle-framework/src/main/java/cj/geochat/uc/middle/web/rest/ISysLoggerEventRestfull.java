package cj.geochat.uc.middle.web.rest;

import cj.geochat.uc.middle.LoggerEventType;
import cj.geochat.uc.middle.model.SysLoggerEvent;

import java.util.List;

public interface ISysLoggerEventRestfull {
    void logger(SysLoggerEvent loggerEvent);

    void remove(String beginTime, String endTime);

    List<SysLoggerEvent> listLogger(long limit, long offset);

    List<SysLoggerEvent> listLoggerByUser(String userId, long limit, long offset);

    List<SysLoggerEvent> listLoggerByType(LoggerEventType eventType, long limit, long offset);

    List<SysLoggerEvent> listLoggerByTime(String beginTime, String endTime, long limit, long offset);

    SysLoggerEvent getLogger(String id);


}
