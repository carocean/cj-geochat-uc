package cj.geochat.uc.iapp.framework.rest;

import cj.geochat.uc.middle.GenderType;
import org.springframework.web.multipart.MultipartFile;

public interface IMyProfileSettingsRestfull {
    void setAvatar(MultipartFile file);

    void setNickName(String nickName);
    void setRealName(String realName);

    void setGender(GenderType gender);

    void setIntroduce(String introduce);

    void setCountry(String countryCode,String countryName);

    void addPhoneNum(String phoneNum);
    void updateMajorAccount(String userId, String accountId);

    void removePhoneNum(String phoneNum);

    void addEmail(String email);

    void removeEmail(String email);

}
