package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.uc.middle.mapper.AppResourceIdDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.AppResourceIdMapper;
import cj.geochat.uc.middle.mapper.PaAppResourceIdDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.PaAppResourceIdMapper;
import cj.geochat.uc.middle.model.AppResourceId;
import cj.geochat.uc.middle.model.PaAppResourceId;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AppResourceIdService implements IAppResourceIdService {
    @Autowired
    AppResourceIdMapper resourceIdMapper;
    @Autowired
    PaAppResourceIdMapper paAppResourceIdMapper;

    @Transactional
    @Override
    public String createResource(String code, String title, String desc) {
        AppResourceId id = new AppResourceId();
        id.setId(UlidCreator.getUlid().toLowerCase());
        id.setResourceCode(code);
        id.setResourceTitle(title);
        id.setResourceDesc(desc);
        resourceIdMapper.insertSelective(id);
        return id.getId();
    }

    @Transactional
    @Override
    public void removeResource(String id) {
        resourceIdMapper.deleteByPrimaryKey(id);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public AppResourceId getResource(String id) {
        return resourceIdMapper.selectByPrimaryKey(id).orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<AppResourceId> listResource() {
        return resourceIdMapper.select(c -> c
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<String> listAllResourceCode() {
        return resourceIdMapper.select(c -> c).stream().map(e -> e.getResourceCode()).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void addResourceIdToApp(String resourceId, String appId) {
        PaAppResourceId paAppResourceId = new PaAppResourceId();
        paAppResourceId.setId(UlidCreator.getUlid().toLowerCase());
        paAppResourceId.setResourceId(resourceId);
        paAppResourceId.setAppId(appId);
        paAppResourceIdMapper.insertSelective(paAppResourceId);
    }

    @Transactional
    @Override
    public void removeResourceIdFromApp(String resourceId, String appId) {
        paAppResourceIdMapper.delete(c -> c
                .where(PaAppResourceIdDynamicSqlSupport.resourceId, SqlBuilder.isEqualTo(resourceId))
                .and(PaAppResourceIdDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<String> listResourceCode(String appId) {
        return resourceIdMapper.select(c -> c
                .join(PaAppResourceIdDynamicSqlSupport.paAppResourceId)
                .on(PaAppResourceIdDynamicSqlSupport.resourceId, SqlBuilder.equalTo(AppResourceIdDynamicSqlSupport.id))
                .where(PaAppResourceIdDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
        ).stream().map(e -> e.getResourceCode()).collect(Collectors.toList());
    }
}
