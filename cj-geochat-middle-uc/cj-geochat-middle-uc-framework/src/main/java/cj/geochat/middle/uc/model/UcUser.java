package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: uc_user
 */
@Data
public class UcUser {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 用户标识。无语义，guid，不作登录用
     */
    private String id;

    /**
     * Column: nick_name
     * Type: VARCHAR(50)
     * Remark: 用户昵称
     */
    private String nickName;

    /**
     * Column: real_name
     * Type: VARCHAR(50)
     * Remark: 真实姓名，用户选填，不作它用
     */
    private String realName;

    /**
     * Column: user_intro
     * Type: VARCHAR(300)
     * Remark: 个性签名
     */
    private String userIntro;

    /**
     * Column: avatar
     * Type: VARCHAR(255)
     * Remark: 头像地址
     */
    private String avatar;

    /**
     * Column: email
     * Type: VARCHAR(255)
     * Remark: 主邮箱
     */
    private String email;

    /**
     * Column: phone
     * Type: VARCHAR(18)
     * Remark: 主电话
     */
    private String phone;

    /**
     * Column: password
     * Type: VARCHAR(255)
     * Remark: 用户密码
     */
    private String password;

    /**
     * Column: salt
     * Type: VARCHAR(64)
     * Remark: 密码盐。一个任意串，用于和密码一起md5
     */
    private String salt;

    /**
     * Column: major_account
     * Type: VARCHAR(50)
     * Remark: 主账号，是登录账号中的一个作为主帐号
     */
    private String majorAccount;

    /**
     * Column: status
     * Type: TINYINT(3)
     * Default value: 0
     * Remark: 0=是正常；1、个人停用；2=平台强制冻结
     */
    private Byte status;

    /**
     * Column: last_login_time
     * Type: VARCHAR(17)
     * Remark: 最后一次登录时间
     */
    private String lastLoginTime;

    /**
     * Column: update_pwd_time
     * Type: VARCHAR(17)
     * Remark: 更新密码时间
     */
    private String updatePwdTime;

    /**
     * Column: ctime
     * Type: VARCHAR(17)
     * Remark: 创建时间
     */
    private String ctime;
}