package cj.geochat.uc.middle.web.rest;

public interface IRegisterUserRestfull {
    String registerUser(String avatar, String nickName, String loginAccountCategory,String openCode, String password, String countryCode,String countryName, boolean isAgreeUPA);


    String registerUserByWechat(String avatar, String nickName, String openid, String city, String province,String countryCode, String countryName, String language, int sex);

    String registerUserByAlipay(String avatar, String nickName, String openid,  String city, String province,String countryCode, String countryName, String gender);
}
