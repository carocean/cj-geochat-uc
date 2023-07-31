package cj.geochat.uc.middle;

import lombok.Data;

import java.util.List;

@Data
public class UserDetails {
    String id;
    String nickName;
    String realName;
    String introduce;
    String avatar;
    String email;
    String phone;
    String password;
    String majorAccount;
    UserStatus status;
    String updatePwdTime;
    String lastLoginTime;
    String ctime;
    String countryCode;
    String countryName;
    boolean agreeUPA;
    List<String> roles;
}
