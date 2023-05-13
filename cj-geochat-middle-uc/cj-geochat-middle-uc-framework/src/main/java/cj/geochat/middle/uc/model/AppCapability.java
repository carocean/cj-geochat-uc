package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: app_capability
 */
@Data
public class AppCapability {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: ability_code
     * Type: VARCHAR(10)
     * Remark: 能力代码
     */
    private String abilityCode;

    /**
     * Column: ability_name
     * Type: VARCHAR(40)
     * Remark: 能力名称
     */
    private String abilityName;

    /**
     * Column: ability_desc
     * Type: VARCHAR(100)
     * Remark: 能力描述
     */
    private String abilityDesc;

    /**
     * Column: order
     * Type: INT
     * Default value: 0
     * Remark: 排序
     */
    private Integer order;
}