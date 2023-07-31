package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.LoggerEventType;
import cj.geochat.uc.middle.model.SysLoggerRegister;
import cj.geochat.uc.middle.service.ISysLoggerRegisterService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sys/logger/register")
@Tag(name = "用户注册日志")
public class SysLoggerRegsiterRestfull implements ISysLoggerRegisterRestfull {
    @Autowired
    ISysLoggerRegisterService loggerRegisterService;

    @PostMapping("/logger")
    @ApiResult
    @Operation(summary = "记录日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void logger(@RequestBody SysLoggerRegister loggerRegister) {
        loggerRegisterService.logger(loggerRegister);
    }

    @GetMapping("/remove")
    @ApiResult
    @Operation(summary = "移除日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void remove(String beginTime, String endTime) {
        loggerRegisterService.remove(beginTime, endTime);
    }

    @GetMapping("/listLogger")
    @ApiResult
    @Operation(summary = "列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerRegister> listLogger(long limit, long offset) {
        return loggerRegisterService.listLogger(limit, offset);
    }

    @GetMapping("/listLoggerByUser")
    @ApiResult
    @Operation(summary = "按用户列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerRegister> listLoggerByUser(String userId, long limit, long offset) {
        return loggerRegisterService.listLoggerByUser(userId, limit, offset);
    }

    @GetMapping("/listLoggerByType")
    @ApiResult
    @Operation(summary = "按事件类型列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerRegister> listLoggerByType(LoggerEventType eventType, long limit, long offset) {
        return loggerRegisterService.listLoggerByType(eventType, limit, offset);
    }

    @GetMapping("/listLoggerByTime")
    @ApiResult
    @Operation(summary = "按时间区间列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerRegister> listLoggerByTime(String beginTime, String endTime, long limit, long offset) {
        return loggerRegisterService.listLoggerByTime(beginTime, endTime, limit, offset);
    }

    @GetMapping("/getLogger")
    @ApiResult
    @Operation(summary = "获取日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public SysLoggerRegister getLogger(String id) {
        return loggerRegisterService.getLogger(id);
    }
}
