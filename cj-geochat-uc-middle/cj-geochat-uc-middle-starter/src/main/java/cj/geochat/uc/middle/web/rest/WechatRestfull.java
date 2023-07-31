package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.model.UcWechat;
import cj.geochat.uc.middle.service.IWechatService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/wechat")
@Tag(name = "微信管理")
public class WechatRestfull implements IWechatRestfull {
    @Autowired
    IWechatService wechatService;

    @GetMapping("/createWechat")
    @ApiResult
    @Operation(summary = "新建微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createWechat(String userId, String openid, @RequestParam(required = false) String nickName, @RequestParam(required = false) int sex, @RequestParam(required = false) String language, @RequestParam(required = false) String city, @RequestParam(required = false) String province, @RequestParam(required = false) String country, @RequestParam(required = false) String avatar) {
        return wechatService.createWechat(userId, openid, nickName, sex, language, city, province, country, avatar);
    }

    @GetMapping("/removeWechat")
    @ApiResult
    @Operation(summary = "移除微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeWechat(String wechatId) {
        wechatService.removeWechat(wechatId);
    }

    @GetMapping("/getWechat")
    @ApiResult
    @Operation(summary = "获取微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcWechat getWechat(String wechatId) {
        return wechatService.getWechat(wechatId);
    }

    @GetMapping("/findWechat")
    @ApiResult
    @Operation(summary = "查找指定openid的微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcWechat findWechat(String openid) {
        return wechatService.findWechat(openid);
    }

    @GetMapping("/listWechat")
    @ApiResult
    @Operation(summary = "列出微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcWechat> listWechat(int limit, long offset) {
        return wechatService.listWechat(limit, offset);
    }

    @GetMapping("/listWechatByUser")
    @ApiResult
    @Operation(summary = "按用户列出微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcWechat> listWechatByUser(String userId) {
        return wechatService.listWechatByUser(userId);
    }

    @GetMapping("/updateWechat")
    @ApiResult
    @Operation(summary = "更新微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateWechat(UcWechat wechat) {
        wechatService.updateWechat(wechat);
    }
}
