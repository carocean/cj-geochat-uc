package cj.geochat.middle.uc.surface;

import cj.geochat.ability.util.GeochatRuntimeException;
import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.model.UcLoginAccount;
import cj.geochat.middle.uc.service.ILoginAccountService;
import cj.geochat.middle.uc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegisterUserSurface implements IRegisterUserSurface {
    @Autowired
    IUserService userService;
    @Autowired
    ILoginAccountService loginAccountService;

    @Transactional
    @Override
    public String registerUserByPhone(String avatar, String nickName, String phone, String password, String countryCode, boolean isAgreeUPA) {
        UcLoginAccount account = loginAccountService.findAccount(LoginAccountCategory.phone.name(), phone);
        if (account != null) {
            throw new GeochatRuntimeException("5000", "手机号已被它人注册");
        }
        String userId = userService.createUser(avatar, nickName, phone, password, countryCode, isAgreeUPA);
        loginAccountService.createAccount(userId, phone, LoginAccountCategory.phone);
        return userId;
    }

    @Transactional
    @Override
    public String registerUserByEmail(String avatar, String nickName, String email, String password, String countryCode, boolean isAgreeUPA) {
        return null;
    }

    @Transactional
    @Override
    public String registerUserByWechat(String avatar, String nickName, String openid, String countryName, String city, String province, String language, int sex) {
        return null;
    }

    @Transactional
    @Override
    public String registerUserByWechat(String avatar, String nickName, String openid, String city, String province, String gender) {
        return null;
    }

}
