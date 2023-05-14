package cj.geochat.middle.uc.surface;

import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.UserDetails;

public interface IUserDetailsSurface {
    UserDetails loadUserDetails(String userId);

    UserDetails loadUserDetailsByAccount(LoginAccountCategory category, String openCode);
}
