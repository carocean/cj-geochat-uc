package cj.geochat.app.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.oauth2.app.DefaultAppAuthentication;
import cj.geochat.ability.oauth2.app.DefaultAppPrincipal;
import cj.geochat.middle.uc.GenderType;
import cj.geochat.app.uc.framework.rest.IMyProfileSettingsRestfull;
import cj.geochat.app.uc.remote.LoginAccountRemote;
import cj.geochat.app.uc.remote.UserRemote;
import cj.geochat.middle.uc.LoginAccountCategory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user/profile/settings")
@Api(description = "我的信息设置",tags = "我的信息设置")
public class MyProfileSettingsRestfull implements IMyProfileSettingsRestfull {
    @Autowired
    UserRemote userRemote;
    @Autowired
    LoginAccountRemote loginAccountRemote;

    @GetMapping("/setAvatar")
    @ApiResult
    @ApiOperation("设置头像")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setAvatar(MultipartFile file) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        String avatar = "";
        file.getName();
        userRemote.updateAvatar(principal.getUserid(), avatar);
    }

    @GetMapping("/setNickName")
    @ApiResult
    @ApiOperation("设置昵称")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setNickName(String nickName) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateNickName(principal.getUserid(), nickName);
    }

    @GetMapping("/setRealName")
    @ApiResult
    @ApiOperation("设置真名")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setRealName(String realName) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateRealName(principal.getUserid(), realName);
    }

    @GetMapping("/setGender")
    @ApiResult
    @ApiOperation("设置性别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setGender(GenderType gender) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateGender(principal.getUserid(), gender);
    }

    @GetMapping("/setIntroduce")
    @ApiResult
    @ApiOperation("设置个人签名")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setIntroduce(String introduce) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateIntro(principal.getUserid(), introduce);
    }

    @GetMapping("/setCountry")
    @ApiResult
    @ApiOperation("设置国家")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setCountry(String countryCode, @RequestParam String countryName) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateCountry(principal.getUserid(), countryCode, countryName);
    }

    @GetMapping("/updateMajorAccount")
    @ApiResult
    @ApiOperation("设置为主账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateMajorAccount(String userId, String accountId) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateMajorAccount(principal.getUserid(), accountId);
    }

    @GetMapping("/addPhoneNum")
    @ApiResult
    @ApiOperation("清加电话号码")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addPhoneNum(String phoneNum) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        loginAccountRemote.createAccount(principal.getUserid(), phoneNum, LoginAccountCategory.phone);
    }

    @GetMapping("/removePhoneNum")
    @ApiResult
    @ApiOperation("移除电话号码")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removePhoneNum(String phoneNum) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        loginAccountRemote.removeAccountByOpenCode(principal.getUserid(), phoneNum, LoginAccountCategory.phone);
    }

    @GetMapping("/addEmail")
    @ApiResult
    @ApiOperation("添加邮箱")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addEmail(String email) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        loginAccountRemote.createAccount(principal.getUserid(), email, LoginAccountCategory.email);
    }

    @GetMapping("/removeEmail")
    @ApiResult
    @ApiOperation("移除邮箱")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeEmail(String email) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        loginAccountRemote.removeAccountByOpenCode(principal.getUserid(), email, LoginAccountCategory.email);
    }
}
