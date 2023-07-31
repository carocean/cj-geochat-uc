package cj.geochat.uc.middle.surface;

import cj.geochat.uc.middle.service.ILoginAccountService;
import cj.geochat.uc.middle.service.IRoleService;
import cj.geochat.uc.middle.service.IUserService;
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
