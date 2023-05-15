package cj.geochat.open.uc.web.rest;

import cj.geochat.open.uc.IReadFully;

import java.io.IOException;

public interface IUserLoginRestfull extends IReadFully {
    void authorization_code(String username, String password) throws IOException;

    void implicit(String username, String password) throws IOException;

    void password(String username, String password) throws IOException;

    void sms_code(String phone_num, String sms_code) throws IOException;

    void refresh_token(String refresh_token) throws IOException;

}
