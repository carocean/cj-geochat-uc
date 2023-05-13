package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.middle.uc.mapper.AppResourceIdDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.AppResourceIdMapper;
import cj.geochat.middle.uc.mapper.PaAppResourceIdDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.PaAppResourceIdMapper;
import cj.geochat.middle.uc.model.AppResourceId;
import cj.geochat.middle.uc.model.PaAppResourceId;
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

    @DataSourceConfig.ReadOnly
    @Override
    public AppResourceId getResource(String id) {
        return resourceIdMapper.selectByPrimaryKey(id).orElse(null);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<AppResourceId> listResource() {
        return resourceIdMapper.select(c -> c
        );
    }

    @DataSourceConfig.ReadOnly
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

    @DataSourceConfig.ReadOnly
    @Override
    public List<String> listResourceCode(String appId) {
        return resourceIdMapper.select(c -> c
                .join(PaAppResourceIdDynamicSqlSupport.paAppResourceId)
                .on(PaAppResourceIdDynamicSqlSupport.resourceId, SqlBuilder.equalTo(AppResourceIdDynamicSqlSupport.id))
                .where(PaAppResourceIdDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
        ).stream().map(e -> e.getResourceCode()).collect(Collectors.toList());
    }
}
