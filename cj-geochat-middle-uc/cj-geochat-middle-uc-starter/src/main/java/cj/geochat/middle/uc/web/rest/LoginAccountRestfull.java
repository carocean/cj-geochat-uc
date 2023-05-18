package cj.geochat.middle.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.model.UcLoginAccount;
import cj.geochat.middle.uc.service.ILoginAccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@Api(description = "登录账号")
public class LoginAccountRestfull implements ILoginAccountRestfull {
    @Autowired
    ILoginAccountService loginAccountService;

    @GetMapping("/createAccount")
    @ApiResult
    @ApiOperation("添加登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createAccount(String userId, String openCode, LoginAccountCategory category) {
        return loginAccountService.createAccount(userId, openCode, category);
    }

    @GetMapping("/removeAccount")
    @ApiResult
    @ApiOperation("移除登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAccount(String account_id) {
        loginAccountService.removeAccount(account_id);
    }

    @GetMapping("/listAccount")
    @ApiResult
    @ApiOperation("列出登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcLoginAccount> listAccount(int limit, int offset) {
        return loginAccountService.listAccount(limit, offset);
    }

    @GetMapping("/listAccountByUser")
    @ApiResult
    @ApiOperation("列出指定用户的登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcLoginAccount> listAccountByUser(String userId) {
        return loginAccountService.listAccountByUser(userId);
    }

    @GetMapping("/getAccount")
    @ApiResult
    @ApiOperation("获取指定账号标识的登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount getAccount(String accountId) {
        return loginAccountService.getAccount(accountId);
    }

    @GetMapping("/removeAccountsByUser")
    @ApiResult
    @ApiOperation("移除指定用户的所有登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAccountsByUser(String userId) {
        loginAccountService.removeAccountsByUser(userId);
    }

    @GetMapping("/findAccount")
    @ApiResult
    @ApiOperation("按账号类型和开放代码查找登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount findAccount(String category, String openCode) {
        return loginAccountService.findAccount(category, openCode);
    }
    @GetMapping("/removeAccountByOpenCode")
    @ApiResult
    @ApiOperation("移除openCode账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAccountByOpenCode(String userid, String openCode, LoginAccountCategory loginAccountCategory) {
        loginAccountService.removeAccountByOpenCode(userid, openCode, loginAccountCategory);
    }
    @GetMapping("/findAccountBy")
    @ApiResult
    @ApiOperation("按条件查找账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount findAccountBy(String userid, LoginAccountCategory category, String openCode) {
        return loginAccountService.findAccountBy(userid,category,openCode);
    }
}
