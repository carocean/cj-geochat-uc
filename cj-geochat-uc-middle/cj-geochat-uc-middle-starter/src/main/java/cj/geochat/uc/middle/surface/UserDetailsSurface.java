package cj.geochat.uc.middle.surface;

import cj.geochat.uc.middle.LoginAccountCategory;
import cj.geochat.uc.middle.UserDetails;
import cj.geochat.uc.middle.UserStatus;
import cj.geochat.uc.middle.model.UcLoginAccount;
import cj.geochat.uc.middle.service.ILoginAccountService;
import cj.geochat.uc.middle.service.IRoleService;
import cj.geochat.uc.middle.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsSurface implements IUserDetailsSurface {
    @Autowired
    IUserService userService;
    @Autowired
    ILoginAccountService loginAccountService;
    @Autowired
    IRoleService roleService;

    @Override
    public UserDetails loadUserDetails(String userId) {
        var user = userService.getUser(userId);
        if (user == null) {
            return null;
        }
        var roles = roleService.listRoleCodeByUser(userId);
        UserDetails details = new UserDetails();
        details.setId(user.getId());
        details.setNickName(user.getNickName());
        details.setRealName(user.getRealName());
        details.setIntroduce(user.getUserIntro());
        details.setAvatar(user.getAvatar());
        details.setEmail(user.getEmail());
        details.setPhone(user.getPhone());
        details.setPassword(user.getPassword());
        details.setMajorAccount(user.getMajorAccount());
        details.setStatus(UserStatus.valueOf(user.getStatus()));
        details.setLastLoginTime(user.getLastLoginTime());
        details.setUpdatePwdTime(user.getUpdatePwdTime());
        details.setCtime(user.getCtime());
        details.setCountryCode(user.getCountryCode());
        details.setCountryName(user.getCountrName());
        details.setAgreeUPA(user.getAgreeUpa());
        details.setRoles(roles);
        return details;
    }

    @Override
    public UserDetails loadUserDetailsByAccount(LoginAccountCategory category, String openCode) {
        UcLoginAccount account = loginAccountService.findAccount(category.name(), openCode);
        if (account == null) {
            return null;
        }
        return loadUserDetails(account.getUserId());
    }
}
