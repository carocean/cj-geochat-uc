package cj.geochat.middle.uc.web;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.LoggerEventType;
import cj.geochat.middle.uc.model.SysLoggerEvent;
import cj.geochat.middle.uc.service.ISysLoggerEventService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sys/logger/event")
@Api(description = "系统事件日志")
public class SysLoggerEventRestfull implements ISysLoggerEventRestfull {
    @Autowired
    ISysLoggerEventService loggerEventService;

    @PostMapping("/logger")
    @ApiResult
    @ApiOperation("记录日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void logger(@RequestBody SysLoggerEvent loggerEvent) {
        loggerEventService.logger(loggerEvent);
    }

    @GetMapping("/remove")
    @ApiResult
    @ApiOperation("移除日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void remove(String beginTime, String endTime) {
        loggerEventService.remove(beginTime, endTime);
    }

    @GetMapping("/listLogger")
    @ApiResult
    @ApiOperation("列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerEvent> listLogger(long limit, long offset) {
        return loggerEventService.listLogger(limit, offset);
    }

    @GetMapping("/listLoggerByUser")
    @ApiResult
    @ApiOperation("按用户列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerEvent> listLoggerByUser(String userId, long limit, long offset) {
        return loggerEventService.listLoggerByUser(userId, limit, offset);
    }

    @GetMapping("/listLoggerByType")
    @ApiResult
    @ApiOperation("按事件类型列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerEvent> listLoggerByType(LoggerEventType eventType, long limit, long offset) {
        return loggerEventService.listLoggerByType(eventType, limit, offset);
    }

    @GetMapping("/listLoggerByTime")
    @ApiResult
    @ApiOperation("按时间区间列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerEvent> listLoggerByTime(String beginTime, String endTime, long limit, long offset) {
        return loggerEventService.listLoggerByTime(beginTime, endTime, limit, offset);
    }

    @GetMapping("/getLogger")
    @ApiResult
    @ApiOperation("获取日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public SysLoggerEvent getLogger(String id) {
        return loggerEventService.getLogger(id);
    }
}
