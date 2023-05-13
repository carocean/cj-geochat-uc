package cj.geochat.middle.uc;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AppDetails {
    String appKey;
    String appSecret;
    List<String> resourceIds = new ArrayList<>();
    List<String> scopes = new ArrayList<>();
    List<String> authorizedGrantTypes = new ArrayList<>();
    List<String> redirectUris = new ArrayList<>();
    List<String> authorities = new ArrayList<>();
    long accessTokenValidity;
    long refreshTokenValidity;
    Object additionalInformation;
    String createTime;
    boolean autoapprove;
}
