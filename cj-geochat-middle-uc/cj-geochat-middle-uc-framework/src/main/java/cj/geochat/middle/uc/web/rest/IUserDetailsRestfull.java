package cj.geochat.middle.uc.web.rest;

import cj.geochat.middle.uc.LoginAccountCategory;
import cj.geochat.middle.uc.UserDetails;

public interface IUserDetailsRestfull {
    UserDetails loadUserDetails(String userId);

    UserDetails loadUserDetailsByAccount(LoginAccountCategory category, String openCode);
}
