package cj.geochat.uc.middle.web.rest;

import cj.geochat.uc.middle.model.UcWechat;

import java.util.List;

public interface IWechatRestfull {

    String createWechat(String userId,String openid,String nickName,int sex,String language,String city,String province,String country,String avatar);

    void removeWechat(String wechatId);

    UcWechat getWechat(String wechatId);

    UcWechat findWechat(String openid);

    List<UcWechat> listWechat(int limit, long offset);

    List<UcWechat> listWechatByUser(String userId);

    void updateWechat(UcWechat wechat);
}
