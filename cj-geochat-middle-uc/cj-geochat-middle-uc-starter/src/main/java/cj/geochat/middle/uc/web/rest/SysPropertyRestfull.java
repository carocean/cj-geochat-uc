package cj.geochat.middle.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.model.SysProps;
import cj.geochat.middle.uc.service.ISysPropertyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sys/properties")
@Api(description = "系统公共参数管理")
public class SysPropertyRestfull implements ISysPropertyRestfull {
    @Autowired
    ISysPropertyService propertyService;

    @GetMapping("/removeById")
    @ApiResult
    @ApiOperation("根据指定id移除属性")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeById(String id) {
        propertyService.removeById(id);
    }

    @GetMapping("/remove")
    @ApiResult
    @ApiOperation("按指定map和key移除属性")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void remove(String map, String key) {
        propertyService.remove(map, key);
    }

    @GetMapping("/put")
    @ApiResult
    @ApiOperation("设置属性，如果存在则覆盖")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void put(String map, String key, String value, @RequestParam(required = false) String note) {
        propertyService.put(map, key, value, note);
    }

    @GetMapping("/getPropertyById")
    @ApiResult
    @ApiOperation("按属性id获取属性信息")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public SysProps getPropertyById(String id) {
        return propertyService.getProperty(id);
    }

    @GetMapping("/getProperty")
    @ApiResult
    @ApiOperation("按属性id获取属性信息")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public SysProps getProperty(String map, String key) {
        return propertyService.getProperty(map, key);
    }

    @GetMapping("/getValue")
    @ApiResult
    @ApiOperation("获取属性值")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String getValue(String map, String key) {
        return propertyService.getValue(map, key);
    }

    @GetMapping("/getNote")
    @ApiResult
    @ApiOperation("获取备注")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String getNote(String map, String key) {
        return propertyService.getNote(map, key);
    }

    @GetMapping("/listProperty")
    @ApiResult
    @ApiOperation("列出属性")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysProps> listProperty(int limit, long offset) {
        return propertyService.listProperty(limit, offset);
    }

    @GetMapping("/listByMap")
    @ApiResult
    @ApiOperation("列出表中属性")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<SysProps> listByMap(String map) {
        return propertyService.listByMap(map);
    }

    @GetMapping("/emptyMap")
    @ApiResult
    @ApiOperation("清空指定表中的所有属性")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void emptyMap(String map) {
        propertyService.emptyMap(map);
    }
}
