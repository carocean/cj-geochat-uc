package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: sys_logger_event
 */
@Data
public class SysLoggerEvent {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: event_type
     * Type: VARCHAR(10)
     * Remark: 事件类型。0=修改密码；1=修改用户状态；2=修改账号状态，等等
     */
    private String eventType;

    /**
     * Column: event_title
     * Type: VARCHAR(50)
     * Remark: 事件名
     */
    private String eventTitle;

    /**
     * Column: event_content
     * Type: VARCHAR(100)
     * Remark: 发生了什么事
     */
    private String eventContent;

    /**
     * Column: user_id
     * Type: VARCHAR(50)
     * Remark: 用户标识
     */
    private String userId;

    /**
     * Column: account_id
     * Type: VARCHAR(50)
     * Remark: 账号标识
     */
    private String accountId;

    /**
     * Column: message
     * Type: VARCHAR(100)
     * Remark: 操作api返回消息
     */
    private String message;

    /**
     * Column: status
     * Type: VARCHAR(20)
     * Remark: 状态
     */
    private String status;

    /**
     * Column: ctime
     * Type: VARCHAR(17)
     * Remark: 创建时间
     */
    private String ctime;
}