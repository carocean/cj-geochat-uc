package cj.geochat.app.uc.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.ability.oauth2.app.DefaultAppAuthentication;
import cj.geochat.ability.oauth2.app.DefaultAppPrincipal;
import cj.geochat.app.uc.framework.rest.IMyAccountRestfull;
import cj.geochat.app.uc.remote.LoginAccountRemote;
import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.model.UcLoginAccount;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user/account")
@Api(description = "我的登录账号",tags = "我的登录账号")
public class MyAccountRestfull implements IMyAccountRestfull {
    @Autowired
    LoginAccountRemote accountRemote;

    @GetMapping("/listMyAccount")
    @ApiResult
    @ApiOperation("列出我的的所有账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcLoginAccount> listMyAccount(String userId) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return accountRemote.listAccountByUser(principal.getUserid());
    }

    @GetMapping("/getAccount")
    @ApiResult
    @ApiOperation("获取账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount getAccount(String accountId) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return accountRemote.getAccount(principal.getName());
    }

    @GetMapping("/removeMyAccounts")
    @ApiResult
    @ApiOperation("移除我的所有账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeMyAccounts(String userId) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        accountRemote.removeAccountsByUser(principal.getUserid());
    }

    @GetMapping("/findMyAccount")
    @ApiResult
    @ApiOperation("查寻我的账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcLoginAccount findMyAccount(LoginAccountCategory category, String openCode) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        return accountRemote.findAccountBy(principal.getUserid(), category, openCode);
    }

    @GetMapping("/removeMyAccount")
    @ApiResult
    @ApiOperation("移除我的账号")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeMyAccount(String openCode, LoginAccountCategory loginAccountCategory) {
        DefaultAppAuthentication authentication = (DefaultAppAuthentication) SecurityContextHolder.getContext().getAuthentication();
        DefaultAppPrincipal principal = (DefaultAppPrincipal) authentication.getPrincipal();
        accountRemote.removeAccountByOpenCode(principal.getUserid(), openCode, loginAccountCategory);
    }
}
