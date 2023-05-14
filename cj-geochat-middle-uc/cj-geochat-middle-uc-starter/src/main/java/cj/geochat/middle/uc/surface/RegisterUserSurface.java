package cj.geochat.middle.uc.surface;

import cj.geochat.ability.util.GeochatRuntimeException;
import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.model.UcUser;
import cj.geochat.middle.uc.service.*;
import com.github.f4b6a3.ulid.UlidCreator;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterUserSurface implements IRegisterUserSurface {
    @Autowired
    IUserService userService;
    @Autowired
    ILoginAccountService loginAccountService;
    @Autowired
    IRoleService roleService;
    @Autowired
    IWechatService wechatService;
    @Autowired
    IAlipayService alipayService;

    @Transactional
    @Override
    public String registerUser(String avatar, String nickName, String loginAccountCategory, String openCode, String password, String countryCode, String countryName, boolean isAgreeUPA) {
        var category = LoginAccountCategory.valueOf(loginAccountCategory);
        var account = loginAccountService.findAccount(category.name(), openCode);
        if (account != null) {
            throw new GeochatRuntimeException("5000", String.format("%s has been registered by others", openCode));
        }
        //查下用户是否存在，不存在则创建，存在则自动将账号关联到这个用户下
        UcUser user = null;
        switch (category) {
            case phone:
                user = userService.findUserByPhone(openCode);
                break;
            case email:
                user = userService.findUserByEmail(openCode);
                break;
            default:
                break;
        }
        var userId = user != null ? user.getId() : userService.createUser(avatar, nickName, password, countryCode, countryName, isAgreeUPA);
        var accountId = loginAccountService.createAccount(userId, openCode, category);
        if (LoginAccountCategory.phone == category) {
            userService.updatePhone(userId, openCode);
        }
        if (LoginAccountCategory.email == category) {
            userService.updateEmail(userId, openCode);
        }
        userService.updateMajorAccount(userId, accountId);
        roleService.addRoleByCodeToUser("general_users", userId);
        //查下是否有地微账号，如果没有则创建
        var accounts = loginAccountService.listAccountOnUser(userId, LoginAccountCategory.geochat.name());
        if (accounts.isEmpty()) {
            loginAccountService.createAccount(userId, UlidCreator.getUlid().toLowerCase(), LoginAccountCategory.geochat);
        }
        return userId;
    }

    @Transactional
    @Override
    public String registerUserByWechat(String avatar, String nickName, String openid, String city, String province, String countryCode, String countryName, String language, int sex) {
        var account = loginAccountService.findAccount(LoginAccountCategory.wechat.name(), openid);
        if (account != null) {
            throw new GeochatRuntimeException("5000", String.format("%s has been registered by others", openid));
        }
        var userId = userService.createUser(avatar, nickName, UlidCreator.getUlid().toLowerCase(), countryCode, countryName, true);
        var accountId = loginAccountService.createAccount(userId, openid, LoginAccountCategory.wechat);
        userService.updateMajorAccount(userId, accountId);
        roleService.addRoleByCodeToUser("general_users", userId);
        wechatService.createWechat(userId, openid, nickName, sex, language, city, province, countryName, avatar);
        //查下是否有地微账号，如果没有则创建
        var accounts = loginAccountService.listAccountOnUser(userId, LoginAccountCategory.geochat.name());
        if (accounts.isEmpty()) {
            loginAccountService.createAccount(userId, UlidCreator.getUlid().toLowerCase(), LoginAccountCategory.geochat);
        }
        return userId;
    }

    @Transactional
    @Override
    public String registerUserByAlipay(String avatar, String nickName, String openid, String city, String province, String countryCode, String countryName, String gender) {
        var account = loginAccountService.findAccount(LoginAccountCategory.alipay.name(), openid);
        if (account != null) {
            throw new GeochatRuntimeException("5000", String.format("%s has been registered by others", openid));
        }
        var userId = userService.createUser(avatar, nickName, UlidCreator.getUlid().toLowerCase(), countryCode, countryName, true);
        var accountId = loginAccountService.createAccount(userId, openid, LoginAccountCategory.alipay);
        userService.updateMajorAccount(userId, accountId);
        roleService.addRoleByCodeToUser("general_users", userId);
        alipayService.createAlipay(userId, openid, nickName, avatar, gender, city, province);
        //查下是否有地微账号，如果没有则创建
        var accounts = loginAccountService.listAccountOnUser(userId, LoginAccountCategory.geochat.name());
        if (accounts.isEmpty()) {
            loginAccountService.createAccount(userId, UlidCreator.getUlid().toLowerCase(), LoginAccountCategory.geochat);
        }
        return userId;
    }

}
