package cj.geochat.uc.middle.model;

import lombok.Data;

/**
 * Table: application
 */
@Data
public class Application {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: app_key
     * Type: VARCHAR(50)
     * Remark: 对应oauth2的app_id
     */
    private String appKey;

    /**
     * Column: app_key_issued_at
     * Type: VARCHAR(17)
     * Remark: 应用key发放日期
     */
    private String appKeyIssuedAt;

    /**
     * Column: app_secret
     * Type: VARCHAR(100)
     * Remark: 秘钥
     */
    private String appSecret;

    /**
     * Column: app_secret_issued_at
     * Type: VARCHAR(17)
     * Remark: 应用密钥发放日期
     */
    private String appSecretIssuedAt;

    /**
     * Column: app_name
     * Type: VARCHAR(40)
     * Remark: 应用名称
     */
    private String appName;

    /**
     * Column: type_id
     * Type: VARCHAR(50)
     * Remark: 关联类型标识
     */
    private String typeId;

    /**
     * Column: cate_id
     * Type: VARCHAR(50)
     * Remark: 关联类别标识
     */
    private String cateId;

    /**
     * Column: autoapprove
     * Type: BIT
     * Default value: 1
     * Remark: 是否开启用户授权确认。0=不开启；1=开启
     */
    private Boolean autoapprove;

    /**
     * Column: refresh_token_validity
     * Type: BIGINT
     * Default value: 2592000
     * Remark: 设定客户端的refresh_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 24 * 30, 30天).
     */
    private Long refreshTokenValidity;

    /**
     * Column: auth_code_validity
     * Type: BIGINT
     * Default value: 600
     * Remark: 设定客户端的authorization_code的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(10*60, 10分钟).
     */
    private Long authCodeValidity;

    /**
     * Column: access_token_validity
     * Type: BIGINT
     * Default value: 2592000
     * Remark: 设定客户端的access_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 12, 12小时).
     */
    private Long accessTokenValidity;

    /**
     * Column: reuse_refresh_tokens
     * Type: BIT
     * Default value: 1
     * Remark: 是否在领牌没过期时生成新令牌
     */
    private Boolean reuseRefreshTokens;
}