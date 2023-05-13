package cj.geochat.middle.uc.restful;

import cj.geochat.middle.uc.LoggerEventType;
import cj.geochat.middle.uc.model.SysLoggerRegister;

import java.util.List;

public interface ISysLoggerRegisterRestfull {
    void logger(SysLoggerRegister loggerRegister);

    void remove(String beginTime, String endTime);

    List<SysLoggerRegister> listLogger(long limit, long offset);

    List<SysLoggerRegister> listLoggerByUser(String userId, long limit, long offset);

    List<SysLoggerRegister> listLoggerByType(LoggerEventType eventType, long limit, long offset);

    List<SysLoggerRegister> listLoggerByTime(String beginTime, String endTime, long limit, long offset);

    SysLoggerRegister getLogger(String id);
}
