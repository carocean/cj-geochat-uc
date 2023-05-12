package cj.geochat.middle.uc.web;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.model.SysProps;
import cj.geochat.middle.uc.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/test")
@Api(description = "测试")
public class TestResource {
    @Autowired
    TestService testService;

    @GetMapping("/test1")
    @ApiResult
    @ApiOperation("测试1")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),
            @ApiResponse(responseCode = "2001", description = "fuck")})
    public String test1(@ApiParam String str) {
        List<SysProps> props = testService.listProp();
        return "test1::" + str;
    }

    @PostMapping("/save")
    @ApiResult
    @ApiOperation("保存")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok"),
            @ApiResponse(responseCode = "2001", description = "fuck")})
    public void save(@RequestBody SysProps sysProps) {
        testService.save(sysProps);
    }
}
