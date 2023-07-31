package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.ability.util.DateUtils;
import cj.geochat.uc.middle.mapper.*;
import cj.geochat.uc.middle.model.Application;
import cj.geochat.uc.middle.model.PaAppGrantType;
import cj.geochat.uc.middle.model.PaAppRedirectUri;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ApplicationService implements IApplicationService {
    @Autowired
    ApplicationMapper applicationMapper;

    @Autowired
    PaAppGrantTypeMapper paAppGrantTypeMapper;

    @Autowired
    PaAppRedirectUriMapper paAppRedirectUriMapper;

    @Transactional
    @Override
    public String createApp(String appName, String appTypeId, String appCategoryId) {
        Application application = new Application();
        application.setId(UlidCreator.getUlid().toLowerCase());
        application.setAppKey(UlidCreator.getUlid().toLowerCase());
        application.setAppSecret(UlidCreator.getUlid().toLowerCase());
        application.setAppName(appName);
        application.setTypeId(appTypeId);
        application.setCateId(appCategoryId);
        application.setAppKeyIssuedAt(DateUtils.dateToLen17(new Date(System.currentTimeMillis())));
        application.setAppSecretIssuedAt(DateUtils.dateToLen17(new Date(System.currentTimeMillis())));
        application.setAutoapprove(true);
        application.setReuseRefreshTokens(true);
        applicationMapper.insertSelective(application);
        return application.getId();
    }

    @Transactional
    @Override
    public void removeApp(String appId) {
        applicationMapper.deleteByPrimaryKey(appId);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public Application getApp(String appId) {
        return applicationMapper.selectByPrimaryKey(appId).orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public Application getAppByKey(String appKey) {
        return applicationMapper.select(c -> c
                .where(ApplicationDynamicSqlSupport.appKey, SqlBuilder.isEqualTo(appKey))
                .limit(1)
        ).stream().findAny().orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<Application> listApp(long limit, long offset) {
        return applicationMapper.select(c -> c
                .orderBy(ApplicationDynamicSqlSupport.appKeyIssuedAt)
                .limit(limit)
                .offset(offset)
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<Application> listAppByType(String appTypeId, long limit, long offset) {
        return applicationMapper.select(c -> c
                .where(ApplicationDynamicSqlSupport.typeId, SqlBuilder.isEqualTo(appTypeId))
                .orderBy(ApplicationDynamicSqlSupport.appKeyIssuedAt)
                .limit(limit)
                .offset(offset)
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<Application> listAppByCategory(String appCategoryId, long limit, long offset) {
        return applicationMapper.select(c -> c
                .where(ApplicationDynamicSqlSupport.cateId, SqlBuilder.isEqualTo(appCategoryId))
                .orderBy(ApplicationDynamicSqlSupport.appKeyIssuedAt)
                .limit(limit)
                .offset(offset)
        );
    }

    @Transactional
    @Override
    public void resetAppSecret(String appId) {
        String newAppSecret = UlidCreator.getUlid().toLowerCase();
        applicationMapper.update(c -> c
                .set(ApplicationDynamicSqlSupport.appSecret).equalTo(newAppSecret)
                .where(ApplicationDynamicSqlSupport.id, SqlBuilder.isEqualTo(appId))
        );
    }
    @Transactional
    @Override
    public void updateAuthCodeValidity(String appId, long intervalSeconds) {
        applicationMapper.update(c -> c
                .set(ApplicationDynamicSqlSupport.authCodeValidity).equalTo(intervalSeconds)
                .where(ApplicationDynamicSqlSupport.id, SqlBuilder.isEqualTo(appId))
        );
    }

    @Transactional
    @Override
    public void updateAccessTokenValidity(String appId, long intervalSeconds) {
        applicationMapper.update(c -> c
                .set(ApplicationDynamicSqlSupport.accessTokenValidity).equalTo(intervalSeconds)
                .where(ApplicationDynamicSqlSupport.id, SqlBuilder.isEqualTo(appId))
        );
    }

    @Transactional
    @Override
    public void updateRefreshTokenValidity(String appId, long intervalSeconds) {
        applicationMapper.update(c -> c
                .set(ApplicationDynamicSqlSupport.refreshTokenValidity).equalTo(intervalSeconds)
                .where(ApplicationDynamicSqlSupport.id, SqlBuilder.isEqualTo(appId))
        );
    }

    @Transactional
    @Override
    public void updateAutoapprove(String appId, boolean autoapprove) {
        applicationMapper.update(c -> c
                .set(ApplicationDynamicSqlSupport.autoapprove).equalTo(autoapprove)
                .where(ApplicationDynamicSqlSupport.id, SqlBuilder.isEqualTo(appId))
        );
    }

    @Transactional
    @Override
    public void updateReuseRefreshTokens(String appId, boolean reuseRefreshTokens) {
        applicationMapper.update(c -> c
                .set(ApplicationDynamicSqlSupport.reuseRefreshTokens).equalTo(reuseRefreshTokens)
                .where(ApplicationDynamicSqlSupport.id, SqlBuilder.isEqualTo(appId))
        );
    }

    @Transactional
    @Override
    public void addGrantTypeToApp(String grantType, String appId) {
        PaAppGrantType paAppGrantType = new PaAppGrantType();
        paAppGrantType.setId(UlidCreator.getUlid().toLowerCase());
        paAppGrantType.setGrantType(grantType);
        paAppGrantType.setAppId(appId);
        paAppGrantTypeMapper.insertSelective(paAppGrantType);
    }

    @Transactional
    @Override
    public void removeGrantTypeFromApp(String grantType, String appId) {
        paAppGrantTypeMapper.select(c -> c
                .where(PaAppGrantTypeDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
                .and(PaAppGrantTypeDynamicSqlSupport.grantType, SqlBuilder.isEqualTo(grantType))
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<String> listGrantType(String appId) {
        return paAppGrantTypeMapper.select(c -> c
                .where(PaAppGrantTypeDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
        ).stream().map(e -> e.getGrantType()).collect(Collectors.toList());
    }

    @Transactional
    @Override
    public void addRedirectUriToApp(String redirectUri, String appId) {
        PaAppRedirectUri paAppRedirectUri = new PaAppRedirectUri();
        paAppRedirectUri.setId(UlidCreator.getUlid().toLowerCase());
        paAppRedirectUri.setRedirectUri(redirectUri);
        paAppRedirectUri.setAppId(appId);
        paAppRedirectUriMapper.insertSelective(paAppRedirectUri);
    }

    @Transactional
    @Override
    public void removeRedirectUriFromApp(String redirectUri, String appId) {
        paAppRedirectUriMapper.delete(c -> c
                .where(PaAppRedirectUriDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
                .and(PaAppRedirectUriDynamicSqlSupport.redirectUri, SqlBuilder.isEqualTo(redirectUri))
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<String> listRedirectUri(String appId) {
        return paAppRedirectUriMapper.select(c -> c
                .where(PaAppRedirectUriDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
        ).stream().map(e -> e.getRedirectUri()).collect(Collectors.toList());
    }
}
