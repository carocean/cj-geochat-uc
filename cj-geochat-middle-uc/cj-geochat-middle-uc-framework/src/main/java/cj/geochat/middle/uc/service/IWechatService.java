package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.model.UcWechat;

import java.util.List;

public interface IWechatService {
    void addWechat(UcWechat wechat);

    void removeWechat(String wechatId);

    UcWechat getWechat(String wechatId);

    UcWechat findWechat(String openid);

    List<UcWechat> listWechat(int limit, long offset);

    List<UcWechat> listWechatByUser(String userId);

    void updateWechat(UcWechat wechat);
}
