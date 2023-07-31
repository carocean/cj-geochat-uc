package cj.geochat.uc.iapp.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.oauth.app.principal.DefaultAppAuthentication;
import cj.geochat.ability.oauth.app.principal.DefaultAppPrincipal;
import cj.geochat.uc.iapp.framework.rest.IMyProfileSettingsRestfull;
import cj.geochat.uc.iapp.remote.LoginAccountRemote;
import cj.geochat.uc.iapp.remote.UserRemote;
import cj.geochat.uc.middle.GenderType;
import cj.geochat.uc.middle.LoginAccountCategory;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/v1/user/profile/settings")
@Tag(name = "我的信息设置")
public class MyProfileSettingsRestfull implements IMyProfileSettingsRestfull {
    @Autowired
    UserRemote userRemote;
    @Autowired
    LoginAccountRemote loginAccountRemote;

    @GetMapping("/setAvatar")
    @ApiResult
    @Operation(summary = "设置头像")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setAvatar(MultipartFile file) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        String avatar = "";
        file.getName();
        userRemote.updateAvatar(principal.getName(), avatar);
    }

    @GetMapping("/setNickName")
    @ApiResult
    @Operation(summary = "设置昵称")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setNickName(String nickName) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateNickName(principal.getName(), nickName);
    }

    @GetMapping("/setRealName")
    @ApiResult
    @Operation(summary = "设置真名")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setRealName(String realName) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateRealName(principal.getName(), realName);
    }

    @GetMapping("/setGender")
    @ApiResult
    @Operation(summary = "设置性别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setGender(GenderType gender) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateGender(principal.getName(), gender);
    }

    @GetMapping("/setIntroduce")
    @ApiResult
    @Operation(summary = "设置个人签名")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setIntroduce(String introduce) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateIntro(principal.getName(), introduce);
    }

    @GetMapping("/setCountry")
    @ApiResult
    @Operation(summary = "设置国家")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void setCountry(String countryCode, @RequestParam String countryName) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateCountry(principal.getName(), countryCode, countryName);
    }

    @GetMapping("/updateMajorAccount")
    @ApiResult
    @Operation(summary = "设置为主账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateMajorAccount(String userId, String accountId) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        userRemote.updateMajorAccount(principal.getName(), accountId);
    }

    @GetMapping("/addPhoneNum")
    @ApiResult
    @Operation(summary = "清加电话号码")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addPhoneNum(String phoneNum) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        loginAccountRemote.createAccount(principal.getName(), phoneNum, LoginAccountCategory.phone);
    }

    @GetMapping("/removePhoneNum")
    @ApiResult
    @Operation(summary = "移除电话号码")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removePhoneNum(String phoneNum) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        loginAccountRemote.removeAccountByOpenCode(principal.getName(), phoneNum, LoginAccountCategory.phone);
    }

    @GetMapping("/addEmail")
    @ApiResult
    @Operation(summary = "添加邮箱")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addEmail(String email) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        loginAccountRemote.createAccount(principal.getName(), email, LoginAccountCategory.email);
    }

    @GetMapping("/removeEmail")
    @ApiResult
    @Operation(summary = "移除邮箱")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeEmail(String email) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        loginAccountRemote.removeAccountByOpenCode(principal.getName(), email, LoginAccountCategory.email);
    }
}
