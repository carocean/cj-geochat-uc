package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.LoggerEventType;
import cj.geochat.uc.middle.model.SysLoggerLogin;
import cj.geochat.uc.middle.service.ISysLoggerLoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sys/logger/login")
@Tag(name = "用户登录日志")
public class SysLoggerLoginRestfull implements ISysLoggerLoginRestfull {
    @Autowired
    ISysLoggerLoginService loggerLoginService;

    @PostMapping("/logger")
    @ApiResult
    @Operation(summary = "记录日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void logger(@RequestBody SysLoggerLogin loggerLogin) {
        loggerLoginService.logger(loggerLogin);
    }

    @GetMapping("/remove")
    @ApiResult
    @Operation(summary = "移除日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void remove(String beginTime, String endTime) {
        loggerLoginService.remove(beginTime, endTime);
    }

    @GetMapping("/listLogger")
    @ApiResult
    @Operation(summary = "列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerLogin> listLogger(long limit, long offset) {
        return loggerLoginService.listLogger(limit, offset);
    }

    @GetMapping("/listLoggerByUser")
    @ApiResult
    @Operation(summary = "按用户列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerLogin> listLoggerByUser(String userId, long limit, long offset) {
        return loggerLoginService.listLoggerByUser(userId, limit, offset);
    }

    @GetMapping("/listLoggerByType")
    @ApiResult
    @Operation(summary = "按类型列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerLogin> listLoggerByType(LoggerEventType eventType, long limit, long offset) {
        return loggerLoginService.listLoggerByType(eventType, limit, offset);
    }

    @GetMapping("/listLoggerByTime")
    @ApiResult
    @Operation(summary = "按时间区间列出日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysLoggerLogin> listLoggerByTime(String beginTime, String endTime, long limit, long offset) {
        return loggerLoginService.listLoggerByTime(beginTime, endTime, limit, offset);
    }

    @GetMapping("/getLogger")
    @ApiResult
    @Operation(summary = "获取日志")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public SysLoggerLogin getLogger(String id) {
        return loggerLoginService.getLogger(id);
    }
}
