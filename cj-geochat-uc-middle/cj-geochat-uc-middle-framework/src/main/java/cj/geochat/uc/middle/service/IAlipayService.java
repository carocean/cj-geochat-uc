package cj.geochat.uc.middle.service;

import cj.geochat.uc.middle.model.UcAlipay;

import java.util.List;

public interface IAlipayService {
    String createAlipay(String userId, String openId, String nickName, String avatar, String gender, String city, String province);

    void removeAlipay(String alipayId);

    UcAlipay getAlipay(String alipayId);

    UcAlipay findAlipay(String openId);

    List<UcAlipay> listAlipay(int limit, long offset);

    List<UcAlipay> listAlipayByUser(String userId);

    void updateAlipay(UcAlipay alipay);

}
