package cj.geochat.uc.middle.service;

import cj.geochat.uc.middle.LoggerEventType;
import cj.geochat.uc.middle.model.SysLoggerLogin;

import java.util.List;

public interface ISysLoggerLoginService {
    void logger(SysLoggerLogin loggerLogin);

    void remove(String beginTime, String endTime);

    List<SysLoggerLogin> listLogger(long limit, long offset);

    List<SysLoggerLogin> listLoggerByUser(String userId, long limit, long offset);

    List<SysLoggerLogin> listLoggerByType(LoggerEventType eventType, long limit, long offset);

    List<SysLoggerLogin> listLoggerByTime(String beginTime, String endTime, long limit, long offset);

    SysLoggerLogin getLogger(String id);


}
