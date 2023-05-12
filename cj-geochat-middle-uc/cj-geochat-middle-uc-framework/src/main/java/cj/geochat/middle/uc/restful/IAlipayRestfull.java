package cj.geochat.middle.uc.restful;

import cj.geochat.middle.uc.model.UcAlipay;

import java.util.List;

public interface IAlipayRestfull {
    String createAlipay(String userId, String openId, String nickName, String avatar, String gender, String city, String province);

    void removeAlipay(String alipayId);

    UcAlipay getAlipay(String alipayId);

    UcAlipay findAlipay(String openId);

    List<UcAlipay> listAlipay(int limit, long offset);

    List<UcAlipay> listAlipayByUser(String userId);

    void updateAlipay(UcAlipay alipay);
}
