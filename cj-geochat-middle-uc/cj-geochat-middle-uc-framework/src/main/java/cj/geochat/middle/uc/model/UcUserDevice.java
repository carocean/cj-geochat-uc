package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: uc_user_device
 */
@Data
public class UcUserDevice {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: user_id
     * Type: VARCHAR(50)
     * Remark: 用户标识
     */
    private String userId;

    /**
     * Column: device_id
     * Type: VARCHAR(50)
     * Remark: 设备标识
     */
    private String deviceId;
}