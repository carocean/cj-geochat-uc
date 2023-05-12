package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: uc_device
 */
@Data
public class UcDevice {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: identifier
     * Type: VARCHAR(50)
     * Remark: 设备唯一标识，厂商内唯一。不充许重复
     */
    private String identifier;

    /**
     * Column: os_name
     * Type: VARCHAR(20)
     * Remark: 设备操作系统
     */
    private String osName;

    /**
     * Column: device_name
     * Type: VARCHAR(20)
     * Remark: 设备名
     */
    private String deviceName;

    /**
     * Column: device_version
     * Type: VARCHAR(10)
     * Remark: 设备版本号
     */
    private String deviceVersion;
}