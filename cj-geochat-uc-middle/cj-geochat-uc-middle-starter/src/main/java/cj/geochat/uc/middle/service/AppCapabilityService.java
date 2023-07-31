package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.uc.middle.mapper.AppCapabilityDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.AppCapabilityMapper;
import cj.geochat.uc.middle.mapper.PaAppCapabilityDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.PaAppCapabilityMapper;
import cj.geochat.uc.middle.model.AppCapability;
import cj.geochat.uc.middle.model.PaAppCapability;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppCapabilityService implements IAppCapabilityService {
    @Autowired
    AppCapabilityMapper capabilityMapper;
    @Autowired
    PaAppCapabilityMapper paAppCapabilityMapper;

    @Transactional
    @Override
    public String createCapability(String code, String name, int order, String desc) {
        AppCapability capability = new AppCapability();
        capability.setId(UlidCreator.getUlid().toLowerCase());
        capability.setAbilityCode(code);
        capability.setAbilityName(name);
        capability.setOrder(order);
        capability.setAbilityDesc(desc);
        capabilityMapper.insertSelective(capability);
        return capability.getId();
    }

    @Transactional
    @Override
    public void removeCapability(String id) {
        capabilityMapper.deleteByPrimaryKey(id);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public AppCapability getCapability(String id) {
        return capabilityMapper.selectByPrimaryKey(id).orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<AppCapability> listCapability() {
        return capabilityMapper.select(c -> c
                .orderBy(AppCapabilityDynamicSqlSupport.order)
        );
    }

    @Transactional
    @Override
    public void updateOrder(String id, int order) {
        capabilityMapper.update(c -> c
                .set(AppCapabilityDynamicSqlSupport.order).equalTo(order)
        );
    }


    @Transactional
    @Override
    public void addCapabilityToApp(String abilityId, String appId) {
        PaAppCapability capability = new PaAppCapability();
        capability.setId(UlidCreator.getUlid().toLowerCase());
        capability.setAppId(appId);
        capability.setAbilityId(abilityId);
        paAppCapabilityMapper.insertSelective(capability);
    }

    @Transactional
    @Override
    public void removeCapabilityFromApp(String abilityId, String appId) {
        paAppCapabilityMapper.delete(c -> c
                .where(PaAppCapabilityDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
                .and(PaAppCapabilityDynamicSqlSupport.abilityId, SqlBuilder.isEqualTo(abilityId))
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<String> listCapabilityCodeOfApp(String appId) {
        return capabilityMapper.select(c -> c
                .join(PaAppCapabilityDynamicSqlSupport.paAppCapability)
                .on(PaAppCapabilityDynamicSqlSupport.abilityId, SqlBuilder.equalTo(AppCapabilityDynamicSqlSupport.id))
                .where(PaAppCapabilityDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
        ).stream().map(e -> e.getAbilityCode()).collect(Collectors.toList());
    }
}
