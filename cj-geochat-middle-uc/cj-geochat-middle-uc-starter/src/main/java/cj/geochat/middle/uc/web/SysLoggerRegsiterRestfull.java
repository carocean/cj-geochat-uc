package cj.geochat.middle.uc.web;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.LoggerEventType;
import cj.geochat.middle.uc.model.SysLoggerRegister;
import cj.geochat.middle.uc.service.ISysLoggerRegisterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sys/logger/register")
@Api(description = "用户注册日志")
public class SysLoggerRegsiterRestfull implements ISysLoggerRegisterRestfull {
    @Autowired
    ISysLoggerRegisterService loggerRegisterService;

    @PostMapping("/logger")
    @ApiResult
    @ApiOperation("记录日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void logger(@RequestBody SysLoggerRegister loggerRegister) {
        loggerRegisterService.logger(loggerRegister);
    }

    @GetMapping("/remove")
    @ApiResult
    @ApiOperation("移除日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void remove(String beginTime, String endTime) {
        loggerRegisterService.remove(beginTime, endTime);
    }

    @GetMapping("/listLogger")
    @ApiResult
    @ApiOperation("列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerRegister> listLogger(long limit, long offset) {
        return loggerRegisterService.listLogger(limit, offset);
    }

    @GetMapping("/listLoggerByUser")
    @ApiResult
    @ApiOperation("按用户列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerRegister> listLoggerByUser(String userId, long limit, long offset) {
        return loggerRegisterService.listLoggerByUser(userId, limit, offset);
    }

    @GetMapping("/listLoggerByType")
    @ApiResult
    @ApiOperation("按事件类型列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerRegister> listLoggerByType(LoggerEventType eventType, long limit, long offset) {
        return loggerRegisterService.listLoggerByType(eventType, limit, offset);
    }

    @GetMapping("/listLoggerByTime")
    @ApiResult
    @ApiOperation("按时间区间列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerRegister> listLoggerByTime(String beginTime, String endTime, long limit, long offset) {
        return loggerRegisterService.listLoggerByTime(beginTime, endTime, limit, offset);
    }

    @GetMapping("/getLogger")
    @ApiResult
    @ApiOperation("获取日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public SysLoggerRegister getLogger(String id) {
        return loggerRegisterService.getLogger(id);
    }
}
