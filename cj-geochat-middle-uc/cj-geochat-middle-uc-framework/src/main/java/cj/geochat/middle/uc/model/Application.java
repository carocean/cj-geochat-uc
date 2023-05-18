package cj.geochat.middle.uc.model;

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
     * Remark: 对应oauth2的client_id
     */
    private String appKey;

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
     * Column: app_secret
     * Type: VARCHAR(100)
     * Remark: 秘钥
     */
    private String appSecret;

    /**
     * Column: access_token_validity
     * Type: BIGINT
     * Remark: 设定客户端的access_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 12, 12小时).
     */
    private Long accessTokenValidity;

    /**
     * Column: refresh_token_validity
     * Type: BIGINT
     * Remark: 设定客户端的refresh_token的有效时间值(单位:秒),可选, 若不设定值则使用默认的有效时间值(60 * 60 * 24 * 30, 30天).
     */
    private Long refreshTokenValidity;

    /**
     * Column: autoapprove
     * Type: BIT
     * Default value: 1
     * Remark: 是否开启用户授权确认。0=不开启；1=开启
     */
    private Boolean autoapprove;

    /**
     * Column: ctime
     * Type: VARCHAR(17)
     * Remark: 创建时间
     */
    private String ctime;

    /**
     * Column: additional_information
     * Type: VARCHAR(1000)
     * Remark: 这是一个预留的字段,在Oauth的流程中没有实际的使用,可选,但若设置值,必须是JSON格式的数据
     */
    private String additionalInformation;
}