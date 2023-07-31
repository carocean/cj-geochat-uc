package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.uc.middle.mapper.UcAlipayDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.UcAlipayMapper;
import cj.geochat.uc.middle.model.UcAlipay;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AlipayService implements IAlipayService {
    @Autowired
    UcAlipayMapper alipayMapper;

    @Transactional
    @Override
    public String createAlipay(String userId, String openId, String nickName, String avatar, String gender, String city, String province) {
        UcAlipay alipay = new UcAlipay();
        alipay.setId(UlidCreator.getUlid().toLowerCase());
        alipay.setCity(city);
        alipay.setAvatar(avatar);
        alipay.setGender(gender);
        alipay.setProvince(province);
        alipay.setNickName(nickName);
        alipay.setOpenId(openId);
        alipay.setUserId(userId);
        alipayMapper.insertSelective(alipay);
        return alipay.getId();
    }

    @Transactional
    @Override
    public void removeAlipay(String alipayId) {
        alipayMapper.deleteByPrimaryKey(alipayId);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcAlipay getAlipay(String alipayId) {
        return alipayMapper.selectByPrimaryKey(alipayId).orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcAlipay findAlipay(String openId) {
        return alipayMapper.select(c -> c
                .where(UcAlipayDynamicSqlSupport.openId, SqlBuilder.isEqualTo(openId))
                .limit(1)
        ).stream().findAny().orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcAlipay> listAlipay(int limit, long offset) {
        return alipayMapper.select(c -> c.limit(limit).offset(offset));
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcAlipay> listAlipayByUser(String userId) {
        return alipayMapper.selectMany(
                SqlBuilder.select(UcAlipayDynamicSqlSupport.ucAlipay.allColumns())
                        .from(UcAlipayDynamicSqlSupport.ucAlipay)
                        .where(UcAlipayDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                        .build().render(RenderingStrategies.MYBATIS3)
        );
    }

    @Transactional
    @Override
    public void updateAlipay(UcAlipay alipay) {
        alipayMapper.updateByPrimaryKeySelective(alipay);
    }
}
