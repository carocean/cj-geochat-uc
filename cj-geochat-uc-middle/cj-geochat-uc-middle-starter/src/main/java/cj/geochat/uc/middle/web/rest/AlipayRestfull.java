package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.model.UcAlipay;
import cj.geochat.uc.middle.service.IAlipayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/alipay")
@Tag(name = "支付宝管理")
public class AlipayRestfull implements IAlipayRestfull {

    @Autowired
    IAlipayService alipayService;

    @GetMapping("/createAlipay")
    @ApiResult
    @Operation(summary = "新建支持宝")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createAlipay(String userId, String openId, @RequestParam(required = false) @Parameter(description = "昵称") String nickName, @RequestParam(required = false) String avatar, @RequestParam(required = false) String gender, @RequestParam(required = false) String city, @RequestParam(required = false) String province) {
        return alipayService.createAlipay(userId, openId, nickName, avatar, gender, city, province);
    }

    @GetMapping("/removeAlipay")
    @ApiResult
    @Operation(summary = "移除支持宝")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAlipay(String alipayId) {
        alipayService.removeAlipay(alipayId);
    }

    @GetMapping("/getAlipay")
    @ApiResult
    @Operation(summary = "获取支持宝")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcAlipay getAlipay(String alipayId) {
        return alipayService.getAlipay(alipayId);
    }

    @GetMapping("/findAlipay")
    @ApiResult
    @Operation(summary = "按openId查找支持宝")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcAlipay findAlipay(String openId) {
        return alipayService.findAlipay(openId);
    }

    @GetMapping("/listAlipay")
    @ApiResult
    @Operation(summary = "列出支付宝")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcAlipay> listAlipay(int limit, long offset) {
        return alipayService.listAlipay(limit, offset);
    }

    @GetMapping("/listAlipayByUser")
    @ApiResult
    @Operation(summary = "列出指定用户的支付宝")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcAlipay> listAlipayByUser(String userId) {
        return alipayService.listAlipayByUser(userId);
    }

    @PostMapping("/updateAlipay")
    @ApiResult
    @Operation(summary = "更新支付宝")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateAlipay(@RequestBody UcAlipay alipay) {
        alipayService.updateAlipay(alipay);
    }
}
