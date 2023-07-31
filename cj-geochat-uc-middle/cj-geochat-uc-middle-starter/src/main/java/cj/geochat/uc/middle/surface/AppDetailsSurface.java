package cj.geochat.uc.middle.surface;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.ability.util.GeochatException;
import cj.geochat.uc.middle.AppDetails;
import cj.geochat.uc.middle.service.IAppCapabilityService;
import cj.geochat.uc.middle.service.IAppResourceIdService;
import cj.geochat.uc.middle.service.IApplicationService;
import cj.geochat.uc.middle.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppDetailsSurface implements IAppDetailsSurface {
    @Autowired
    IApplicationService applicationService;
    @Autowired
    IAppCapabilityService capabilityService;
    @Autowired
    IAppResourceIdService resourceIdService;
    @Autowired
    IRoleService roleService;

    @AccessDBPolicy.ReadOnly
    @Override
    public AppDetails loadAppByAppKey(String appKey) throws GeochatException {
        var application = applicationService.getAppByKey(appKey);
        if (application == null) {
            throw new GeochatException("4004", String.format("AppKey:%s does not exist.", appKey));
        }
        var appId = application.getId();
        var capabilities = capabilityService.listCapabilityCodeOfApp(appId);
        var resourceids = resourceIdService.listResourceCode(appId);
        var authorities = roleService.listAuthorityCodeOfApp(appId);
        var grantTypes = applicationService.listGrantType(appId);
        var redirectUris = applicationService.listRedirectUri(appId);
        var details = new AppDetails();
        details.setAppKey(application.getAppKey());
        details.setAppSecret(application.getAppSecret());
        details.setAutoapprove(application.getAutoapprove());
        details.setCreateTime(application.getCtime());
        details.setAdditionalInformation(application.getAdditionalInformation());
        details.setAccessTokenValidity(application.getAccessTokenValidity() == null ? 0 : application.getAccessTokenValidity());
        details.setRefreshTokenValidity(application.getRefreshTokenValidity() == null ? 0 : application.getRefreshTokenValidity());
        details.setGrantTypes(grantTypes);
        details.setResourceIds(resourceids);
        details.setAuthorities(authorities);
        details.setScopes(capabilities);
        details.setRedirectUris(redirectUris);
        return details;
    }
}
