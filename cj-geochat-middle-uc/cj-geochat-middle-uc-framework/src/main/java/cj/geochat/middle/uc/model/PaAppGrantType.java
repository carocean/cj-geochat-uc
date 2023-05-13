package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: pa_app_grant_type
 */
@Data
public class PaAppGrantType {
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
     * Column: grant_type
     * Type: VARCHAR(20)
     * Remark: 授权类型代码
     */
    private String grantType;
}