package cj.geochat.middle.uc.web.rest;

import cj.geochat.middle.uc.UserStatus;
import cj.geochat.middle.uc.model.UcUser;

import java.io.UnsupportedEncodingException;
import java.util.List;

public interface IUserRestfull {
    String createUser(String avatar, String nickName, String password, String countryCode,String countryName,  boolean isAgreeUPA) throws UnsupportedEncodingException;

    void removeUser(String userId);

    List<UcUser> listUser(int limit, int offset);

    UcUser getUser(String userId);

    void updatePwd(String userId, String pwd);

    void updateLoginTime(String userId);

    void updateStatus(String userId, UserStatus status);

    void updateAvatar(String userId, String avatar);

    void updateInfo(String userId, String realName, String email, String phone);

    void updateNickName(String userId, String nickName);
    void updateIntro(String userId, String intro);

    void updateMajorAccount(String userId, String accountId);
}
