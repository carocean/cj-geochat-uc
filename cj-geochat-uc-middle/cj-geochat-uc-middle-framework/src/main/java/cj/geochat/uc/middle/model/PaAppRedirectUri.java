package cj.geochat.uc.middle.model;

import lombok.Data;

/**
 * Table: pa_app_redirect_uri
 */
@Data
public class PaAppRedirectUri {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: app_id
     * Type: VARCHAR(50)
     * Remark: 应用标识
     */
    private String appId;

    /**
     * Column: redirect_uri
     * Type: VARCHAR(255)
     * Remark: 重定向地址
     */
    private String redirectUri;
}