package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.UserStatus;
import cj.geochat.middle.uc.model.UcUser;

import java.util.List;

public interface IUserService {
    String createUser(String avatar, String nickName, String phone, String password, String countryCode, boolean isAgreeUPA);

    void removeUser(String userId);

    List<UcUser> listUser(int limit, int offset);

    UcUser getUser(String userId);

    void updatePwd(String userId, String pwd);

    void updateLoginTIme(String userId);

    void updateStatus(String userId, UserStatus status);

    void updateAvatar(String userId, String avatar);

    void updateInfo(String userId, String realName, String email, String phone);

    void updateNickName(String userId, String nickName);
    void updateIntro(String userId, String intro);

    void updateMajorAccount(String userId, String accountId);
}