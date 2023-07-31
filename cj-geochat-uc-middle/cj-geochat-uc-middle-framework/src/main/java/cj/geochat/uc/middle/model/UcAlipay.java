package cj.geochat.uc.middle.model;

import lombok.Data;

/**
 * Table: uc_alipay
 */
@Data
public class UcAlipay {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: open_id
     * Type: VARCHAR(50)
     * Remark: 用户标识,对应支付宝user_id
     */
    private String openId;

    /**
     * Column: nick_name
     * Type: VARCHAR(50)
     * Remark: 昵称
     */
    private String nickName;

    /**
     * Column: avatar
     * Type: VARCHAR(255)
     * Remark: 头像
     */
    private String avatar;

    /**
     * Column: gender
     * Type: VARCHAR(5)
     * Remark: 性别
     */
    private String gender;

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
     * Column: user_id
     * Type: VARCHAR(50)
     * Remark: 所属用户
     */
    private String userId;
}