package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.GenderType;
import cj.geochat.uc.middle.UserStatus;
import cj.geochat.uc.middle.model.UcUser;
import cj.geochat.uc.middle.service.IUserService;
import cj.geochat.uc.middle.surface.IRegisterUserSurface;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "用户")
public class UserRestfull implements IUserRestfull {
    @Autowired
    IUserService userService;
    @Autowired
    IRegisterUserSurface registerUserService;

    @GetMapping("/createUser")
    @ApiResult
    @Operation(summary = "新建用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createUser(String avatar, String nickName, String password, @RequestParam(required = false) String countryCode, @RequestParam(required = false) String countryName, boolean isAgreeUPA) throws UnsupportedEncodingException {
        return userService.createUser(avatar, nickName, password, countryCode, countryName, isAgreeUPA);
    }

    @GetMapping("/removeUser")
    @ApiResult
    @Operation(summary = "移除用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeUser(@RequestParam String userId) {
        userService.removeUser(userId);
    }

    @GetMapping("/listUser")
    @ApiResult
    @Operation(summary = "列出用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcUser> listUser(@RequestParam int limit, @RequestParam int offset) {
        return userService.listUser(limit, offset);
    }

    @GetMapping("/getUser")
    @ApiResult
    @Operation(summary = "获取用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcUser getUser(String userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/updatePwd")
    @ApiResult
    @Operation(summary = "更新密码")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updatePwd(String userId, String pwd) {
        userService.updatePwd(userId, pwd);
    }

    @GetMapping("/updateLoginTime")
    @ApiResult
    @Operation(summary = "更新用户最近一次登录时间")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateLoginTime(String userId) {
        userService.updateLoginTIme(userId);
    }

    @GetMapping("/updateStatus")
    @ApiResult
    @Operation(summary = "更新用户状态")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateStatus(String userId, UserStatus status) {
        userService.updateStatus(userId, status);
    }

    @GetMapping("/updateAvatar")
    @ApiResult
    @Operation(summary = "更新用户头像")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateAvatar(String userId, String avatar) {
        userService.updateAvatar(userId, avatar);
    }

    @GetMapping("/updateInfo")
    @ApiResult
    @Operation(summary = "更新用户信息")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateInfo(String userId, String realName, String email, String phone) {
        userService.updateInfo(userId, realName, email, phone);
    }

    @GetMapping("/updateNickName")
    @ApiResult
    @Operation(summary = "更新用户昵称")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateNickName(String userId, String nickName) {
        userService.updateNickName(userId, nickName);
    }

    @GetMapping("/updateIntro")
    @ApiResult
    @Operation(summary = "更新用户个人签名")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateIntro(String userId, String intro) {
        userService.updateIntro(userId, intro);
    }

    @GetMapping("/updateMajorAccount")
    @ApiResult
    @Operation(summary = "更新用户主账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateMajorAccount(String userId, @Parameter(name = "主登录账号") String accountId) {
        userService.updateMajorAccount(userId, accountId);
    }

    @GetMapping("/updateRealName")
    @ApiResult
    @Operation(summary = "更新真名")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateRealName(String userid, String realName) {
        userService.updateRealName(userid, realName);
    }

    @GetMapping("/updateGender")
    @ApiResult
    @Operation(summary = "更新性别")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateGender(String userid, GenderType gender) {
        userService.updateGender(userid, gender);
    }

    @GetMapping("/updateCountry")
    @ApiResult
    @Operation(summary = "更新国家")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void updateCountry(String userid, String countryCode, @RequestParam(required = false) String countryName) {
        userService.updateCountry(userid, countryCode, countryName);
    }
}
