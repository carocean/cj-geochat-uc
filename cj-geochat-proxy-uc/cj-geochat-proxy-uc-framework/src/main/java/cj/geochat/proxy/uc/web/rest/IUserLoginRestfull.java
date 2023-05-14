package cj.geochat.proxy.uc.web.rest;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

public interface IUserLoginRestfull {
    String authorization_code(String username, String password) throws IOException;

    String implicit(String username, String password) throws IOException;

    String password(String username, String password) throws IOException;

    String sms_code(String phone_num, String sms_code) throws IOException;

    String refresh_token(String refresh_token) throws IOException;

    default byte[] readFully(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[80960];
        int len = 0;
        while ((len = inputStream.read(buffer)) >= 0) {
            outputStream.write(buffer, 0, len);
        }
        return outputStream.toByteArray();
    }
}
