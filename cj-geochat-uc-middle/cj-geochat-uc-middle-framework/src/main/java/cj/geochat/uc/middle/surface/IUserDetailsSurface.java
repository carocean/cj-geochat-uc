package cj.geochat.uc.middle.surface;

import cj.geochat.uc.middle.LoginAccountCategory;
import cj.geochat.uc.middle.UserDetails;

public interface IUserDetailsSurface {
    UserDetails loadUserDetails(String userId);

    UserDetails loadUserDetailsByAccount(LoginAccountCategory category, String openCode);
}
