package cj.geochat.proxy.uc.web.rest;

import cj.geochat.proxy.uc.IReadFully;

import java.io.IOException;

public interface IAuthRestfull extends IReadFully {

    String authorizeAuthorizationCode(String state) throws IOException;
    String authorizeImplicit(String state) throws IOException;

    String confirmAccess(boolean user_oauth_approval, boolean scope_all) throws IOException;

    String tokenAuthorizationCode(String code) throws IOException;

    String logout(String access_token) throws IOException;
}
