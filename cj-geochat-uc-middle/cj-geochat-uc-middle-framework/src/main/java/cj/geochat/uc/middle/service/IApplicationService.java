package cj.geochat.uc.middle.service;

import cj.geochat.uc.middle.model.Application;

import java.util.List;

public interface IApplicationService {
    String createApp(String appName, String appTypeId, String appCategoryId);

    void removeApp(String appId);

    Application getApp(String appId);

    Application getAppByKey(String appKey);

    List<Application> listApp(long limit, long offset);

    List<Application> listAppByType(String appTypeId, long limit, long offset);

    List<Application> listAppByCategory(String appCategoryId, long limit, long offset);

    void resetAppSecret(String appId);

    void updateAuthCodeValidity(String appId, long intervalSeconds);
    void updateAccessTokenValidity(String appId, long intervalSeconds);

    void updateRefreshTokenValidity(String appId, long intervalSeconds);

    void updateAutoapprove(String appId, boolean autoapprove);

    void updateReuseRefreshTokens(String appId, boolean reuseRefreshTokens);

    void addGrantTypeToApp(String grantType, String appId);

    void removeGrantTypeFromApp(String grantType, String appId);

    List<String> listGrantType(String appId);

    void addRedirectUriToApp(String redirectUri, String appId);

    void removeRedirectUriFromApp(String redirectUri, String appId);

    List<String> listRedirectUri(String appId);

}
