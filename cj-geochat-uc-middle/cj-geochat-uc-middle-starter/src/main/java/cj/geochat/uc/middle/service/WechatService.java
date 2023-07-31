package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.uc.middle.mapper.UcWechatDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.UcWechatMapper;
import cj.geochat.uc.middle.model.UcWechat;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WechatService implements IWechatService {
    @Autowired
    UcWechatMapper wechatMapper;

    @Transactional
    @Override
    public String createWechat(
            String userId, String openid, String nickName, int sex,
            String language, String city, String province, String country, String avatar) {
        UcWechat wechat = new UcWechat();
        wechat.setId(UlidCreator.getUlid().toLowerCase());
        wechat.setUserId(userId);
        wechat.setOpenid(openid);
        wechat.setNickName(nickName);
        wechat.setSex(sex);
        wechat.setLanguage(language);
        wechat.setCity(city);
        wechat.setProvince(province);
        wechat.setCountry(country);
        wechat.setHeadimgurl(avatar);
        wechatMapper.insertSelective(wechat);
        return wechat.getId();
    }

    @Transactional
    @Override
    public void removeWechat(String wechatId) {
        wechatMapper.deleteByPrimaryKey(wechatId);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcWechat getWechat(String wechatId) {
        return wechatMapper.selectByPrimaryKey(wechatId).orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcWechat findWechat(String openid) {
        return wechatMapper.select(c -> c
                .where(UcWechatDynamicSqlSupport.openid, SqlBuilder.isEqualTo(openid))
                .limit(1)
        ).stream().findAny().orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcWechat> listWechat(int limit, long offset) {
        return wechatMapper.select(c -> c
                .limit(limit).offset(offset)
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcWechat> listWechatByUser(String userId) {
        return wechatMapper.select(c -> c
                .where(UcWechatDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void updateWechat(UcWechat wechat) {
        wechatMapper.updateByPrimaryKeySelective(wechat);
    }
}
