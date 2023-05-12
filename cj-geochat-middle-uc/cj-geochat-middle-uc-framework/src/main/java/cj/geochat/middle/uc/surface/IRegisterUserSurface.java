package cj.geochat.middle.uc.surface;

public interface IRegisterUserSurface {
    String registerUserByPhone(String avatar, String nickName, String phone, String password, String countryCode, boolean isAgreeUPA);

    String registerUserByEmail(String avatar, String nickName, String email, String password, String countryCode, boolean isAgreeUPA);

    String registerUserByWechat(String avatar, String nickName, String openid, String countryName, String city, String province, String language, int sex);

    String registerUserByWechat(String avatar, String nickName, String openid,  String city, String province, String gender);
}
