package cj.geochat.proxy.uc.web.rest;

import cj.geochat.proxy.uc.IReadFully;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public interface IUserLoginRestfull extends IReadFully {
    String authorization_code(String username, String password) throws IOException;

    String implicit(String username, String password) throws IOException;

    String password(String username, String password) throws IOException;

    String sms_code(String phone_num, String sms_code) throws IOException;

    String refresh_token(String refresh_token) throws IOException;

}
