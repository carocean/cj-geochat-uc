package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: uc_login_account
 */
@Data
public class UcLoginAccount {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: user_id
     * Type: VARCHAR(50)
     * Remark: 所属用户
     */
    private String userId;

    /**
     * Column: open_code
     * Type: VARCHAR(255)
     * Remark: 登录账号,如手机号等
     */
    private String openCode;

    /**
     * Column: category
     * Type: VARCHAR(10)
     * Remark: 账号类别
     */
    private String category;

    /**
     * Column: ctime
     * Type: VARCHAR(17)
     * Remark: 创建时间
     */
    private String ctime;
}