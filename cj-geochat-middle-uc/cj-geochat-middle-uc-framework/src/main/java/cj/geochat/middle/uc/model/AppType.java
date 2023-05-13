package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: app_type
 */
@Data
public class AppType {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: type_code
     * Type: VARCHAR(10)
     * Remark: 类型代码
     */
    private String typeCode;

    /**
     * Column: type_name
     * Type: VARCHAR(40)
     * Remark: 类型名
     */
    private String typeName;

    /**
     * Column: type_desc
     * Type: VARCHAR(100)
     * Remark: 类型描述
     */
    private String typeDesc;
}