package cj.geochat.uc.iapp.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.oauth.app.principal.DefaultAppAuthentication;
import cj.geochat.ability.oauth.app.principal.DefaultAppPrincipal;
import cj.geochat.uc.iapp.framework.rest.IMyAccountRestfull;
import cj.geochat.uc.iapp.remote.LoginAccountRemote;
import cj.geochat.uc.middle.LoginAccountCategory;
import cj.geochat.uc.middle.model.UcLoginAccount;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/account")
@Tag(name = "我的登录账号")
public class MyAccountRestfull implements IMyAccountRestfull {
    @Autowired
    LoginAccountRemote accountRemote;

    @GetMapping("/listMyAccount")
    @ApiResult
    @Operation(summary = "列出我的的所有账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcLoginAccount> listMyAccount(String userId) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return accountRemote.listAccountByUser(principal.getName());
    }

    @GetMapping("/getAccount")
    @ApiResult
    @Operation(summary = "获取账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount getAccount(String accountId) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return accountRemote.getAccount(principal.getName());
    }

    @GetMapping("/removeMyAccounts")
    @ApiResult
    @Operation(summary = "移除我的所有账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeMyAccounts(String userId) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        accountRemote.removeAccountsByUser(principal.getName());
    }

    @GetMapping("/findMyAccount")
    @ApiResult
    @Operation(summary = "查寻我的账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount findMyAccount(LoginAccountCategory category, String openCode) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return accountRemote.findAccountBy(principal.getName(), category, openCode);
    }

    @GetMapping("/removeMyAccount")
    @ApiResult
    @Operation(summary = "移除我的账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeMyAccount(String openCode, LoginAccountCategory loginAccountCategory) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        accountRemote.removeAccountByOpenCode(principal.getName(), openCode, loginAccountCategory);
    }
}
