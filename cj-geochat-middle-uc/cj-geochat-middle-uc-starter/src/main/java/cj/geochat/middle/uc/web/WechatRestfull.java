package cj.geochat.middle.uc.web;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.model.UcWechat;
import cj.geochat.middle.uc.service.IWechatService;
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
@RequestMapping("/api/v1/wechat")
@Api(description = "微信管理")
public class WechatRestfull implements IWechatRestfull {
    @Autowired
    IWechatService wechatService;

    @GetMapping("/createWechat")
    @ApiResult
    @ApiOperation("新建微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createWechat(String userId, String openid, @RequestParam(required = false) String nickName, @RequestParam(required = false) int sex, @RequestParam(required = false) String language, @RequestParam(required = false) String city, @RequestParam(required = false) String province, @RequestParam(required = false) String country, @RequestParam(required = false) String avatar) {
        return wechatService.createWechat(userId, openid, nickName, sex, language, city, province, country, avatar);
    }

    @GetMapping("/removeWechat")
    @ApiResult
    @ApiOperation("移除微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeWechat(String wechatId) {
        wechatService.removeWechat(wechatId);
    }

    @GetMapping("/getWechat")
    @ApiResult
    @ApiOperation("获取微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcWechat getWechat(String wechatId) {
        return wechatService.getWechat(wechatId);
    }

    @GetMapping("/findWechat")
    @ApiResult
    @ApiOperation("查找指定openid的微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcWechat findWechat(String openid) {
        return wechatService.findWechat(openid);
    }

    @GetMapping("/listWechat")
    @ApiResult
    @ApiOperation("列出微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcWechat> listWechat(int limit, long offset) {
        return wechatService.listWechat(limit, offset);
    }

    @GetMapping("/listWechatByUser")
    @ApiResult
    @ApiOperation("按用户列出微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcWechat> listWechatByUser(String userId) {
        return wechatService.listWechatByUser(userId);
    }

    @GetMapping("/updateWechat")
    @ApiResult
    @ApiOperation("更新微信")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateWechat(UcWechat wechat) {
        wechatService.updateWechat(wechat);
    }
}
