package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.LoginAccountCategory;
import cj.geochat.uc.middle.model.UcLoginAccount;
import cj.geochat.uc.middle.service.ILoginAccountService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@Tag(name = "登录账号")
public class LoginAccountRestfull implements ILoginAccountRestfull {
    @Autowired
    ILoginAccountService loginAccountService;

    @GetMapping("/createAccount")
    @ApiResult
    @Operation(summary = "添加登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createAccount(String userId, String openCode, LoginAccountCategory category) {
        return loginAccountService.createAccount(userId, openCode, category);
    }

    @GetMapping("/removeAccount")
    @ApiResult
    @Operation(summary = "移除登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAccount(String account_id) {
        loginAccountService.removeAccount(account_id);
    }

    @GetMapping("/listAccount")
    @ApiResult
    @Operation(summary = "列出登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcLoginAccount> listAccount(int limit, int offset) {
        return loginAccountService.listAccount(limit, offset);
    }

    @GetMapping("/listAccountByUser")
    @ApiResult
    @Operation(summary = "列出指定用户的登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcLoginAccount> listAccountByUser(String userId) {
        return loginAccountService.listAccountByUser(userId);
    }

    @GetMapping("/getAccount")
    @ApiResult
    @Operation(summary = "获取指定账号标识的登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount getAccount(String accountId) {
        return loginAccountService.getAccount(accountId);
    }

    @GetMapping("/removeAccountsByUser")
    @ApiResult
    @Operation(summary = "移除指定用户的所有登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAccountsByUser(String userId) {
        loginAccountService.removeAccountsByUser(userId);
    }

    @GetMapping("/findAccount")
    @ApiResult
    @Operation(summary = "按账号类型和开放代码查找登录账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount findAccount(String category, String openCode) {
        return loginAccountService.findAccount(category, openCode);
    }
    @GetMapping("/removeAccountByOpenCode")
    @ApiResult
    @Operation(summary = "移除openCode账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAccountByOpenCode(String userid, String openCode, LoginAccountCategory loginAccountCategory) {
        loginAccountService.removeAccountByOpenCode(userid, openCode, loginAccountCategory);
    }
    @GetMapping("/findAccountBy")
    @ApiResult
    @Operation(summary = "按条件查找账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount findAccountBy(String userid, LoginAccountCategory category, String openCode) {
        return loginAccountService.findAccountBy(userid,category,openCode);
    }
}
