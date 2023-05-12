package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: uc_wechat
 */
@Data
public class UcWechat {
    /**
     * Column: id
     * Type: VARCHAR(50)
     */
    private String id;

    /**
     * Column: openid
     * Type: VARCHAR(50)
     * Remark: 用户标识
     */
    private String openid;

    /**
     * Column: nick_name
     * Type: VARCHAR(50)
     * Remark: 昵称
     */
    private String nickName;

    /**
     * Column: sex
     * Type: INT
     * Remark: 性别
     */
    private Integer sex;

    /**
     * Column: language
     * Type: VARCHAR(10)
     * Remark: 语言
     */
    private String language;

    /**
     * Column: city
     * Type: VARCHAR(50)
     * Remark: 城市
     */
    private String city;

    /**
     * Column: province
     * Type: VARCHAR(50)
     * Remark: 省份
     */
    private String province;

    /**
     * Column: country
     * Type: VARCHAR(50)
     * Remark: 国家
     */
    private String country;

    /**
     * Column: headimgurl
     * Type: VARCHAR(255)
     * Remark: 头像
     */
    private String headimgurl;

    /**
     * Column: user_id
     * Type: VARCHAR(50)
     * Remark: 所属用户
     */
    private String userId;
}