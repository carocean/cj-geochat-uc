package cj.geochat.uc.middle;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AppDetails {
    String id;
    String appKey;
    String appKeyIssuedAt;
    String appSecret;
    String appSecretIssuedAt;
    String appName;
    List<String> resourceIds = new ArrayList<>();
    List<String> scopes = new ArrayList<>();
    List<String> grantTypes = new ArrayList<>();
    List<String> redirectUris = new ArrayList<>();
    List<String> authorities = new ArrayList<>();
    long authCodeValidity;
    long accessTokenValidity;
    long refreshTokenValidity;
    boolean autoapprove;
    boolean reuseRefreshTokens;
}
