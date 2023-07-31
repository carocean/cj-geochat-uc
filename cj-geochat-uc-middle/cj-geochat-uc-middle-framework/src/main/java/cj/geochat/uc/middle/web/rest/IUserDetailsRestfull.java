package cj.geochat.uc.middle.web.rest;

import cj.geochat.uc.middle.LoginAccountCategory;
import cj.geochat.uc.middle.UserDetails;

public interface IUserDetailsRestfull {
    UserDetails loadUserDetails(String userId);

    UserDetails loadUserDetailsByAccount(LoginAccountCategory category, String openCode);
}
