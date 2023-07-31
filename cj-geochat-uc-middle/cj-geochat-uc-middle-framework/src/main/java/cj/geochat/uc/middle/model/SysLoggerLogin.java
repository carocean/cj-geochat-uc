package cj.geochat.uc.middle.model;

import lombok.Data;

/**
 * Table: sys_logger_login
 */
@Data
public class SysLoggerLogin {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: event_type
     * Type: VARCHAR(10)
     * Remark: 事件类型。0=登录；1=退出
     */
    private String eventType;

    /**
     * Column: event_title
     * Type: VARCHAR(50)
     * Remark: 事件描述，与类型匹配
     */
    private String eventTitle;

    /**
     * Column: user_id
     * Type: VARCHAR(50)
     * Remark: 用户标识
     */
    private String userId;

    /**
     * Column: account_id
     * Type: VARCHAR(50)
     * Remark: 登录账号标识
     */
    private String accountId;

    /**
     * Column: account_cate
     * Type: BIT
     * Remark: 登录账号的类型。与账号表的category一致
     */
    private Boolean accountCate;

    /**
     * Column: source_type
     * Type: TINYINT(3)
     * Remark: 来源类型：0=地微app；1=地微平台
     */
    private Byte sourceType;

    /**
     * Column: source_desc
     * Type: VARCHAR(100)
     * Remark: 来源描述
     */
    private String sourceDesc;

    /**
     * Column: message
     * Type: VARCHAR(500)
     * Remark: 一般是api调用返回消息
     */
    private String message;

    /**
     * Column: status
     * Type: VARCHAR(100)
     * Remark: 状态，一般是api返回状态
     */
    private String status;

    /**
     * Column: ip_address
     * Type: VARCHAR(20)
     * Remark: 登录ip地址
     */
    private String ipAddress;

    /**
     * Column: device_id
     * Type: VARCHAR(50)
     * Remark: 事件发生设备
     */
    private String deviceId;

    /**
     * Column: ctime
     * Type: VARCHAR(17)
     * Remark: 发生时间
     */
    private String ctime;

    /**
     * Column: year
     * Type: INT
     * Remark: 年
     */
    private Integer year;

    /**
     * Column: month
     * Type: INT
     * Remark: 月
     */
    private Integer month;

    /**
     * Column: day
     * Type: INT
     * Remark: 日
     */
    private Integer day;
}