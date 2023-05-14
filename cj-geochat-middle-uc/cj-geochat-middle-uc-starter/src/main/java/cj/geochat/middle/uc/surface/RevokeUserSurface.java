package cj.geochat.middle.uc.surface;

import cj.geochat.middle.uc.service.ILoginAccountService;
import cj.geochat.middle.uc.service.IRoleService;
import cj.geochat.middle.uc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RevokeUserSurface implements IRevokeUserSurface {
    @Autowired
    IUserService userService;
    @Autowired
    ILoginAccountService loginAccountService;
    @Autowired
    IRoleService roleService;

    @Transactional
    @Override
    public void revokeUser(String userId) {
        userService.removeUser(userId);
        loginAccountService.removeAccountsByUser(userId);
        roleService.emptyRoleOfUser(userId);
    }
}
