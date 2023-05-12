package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: sys_props
 */
@Data
public class SysProps {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识。guid
     */
    private String id;

    /**
     * Column: map
     * Type: VARCHAR(50)
     * Remark: 可视为表名
     */
    private String map;

    /**
     * Column: key
     * Type: VARCHAR(50)
     * Remark: 一个map的key
     */
    private String key;

    /**
     * Column: value
     * Type: VARCHAR(255)
     * Remark: 一个map的key的设置值
     */
    private String value;

    /**
     * Column: note
     * Type: VARCHAR(100)
     * Remark: 备注
     */
    private String note;
}