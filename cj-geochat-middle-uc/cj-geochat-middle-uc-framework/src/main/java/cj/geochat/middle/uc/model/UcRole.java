package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: uc_role
 */
@Data
public class UcRole {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: role_code
     * Type: VARCHAR(50)
     * Remark: 角色代码，程序使用的是角色代码
     */
    private String roleCode;

    /**
     * Column: role_name
     * Type: VARCHAR(20)
     * Remark: 角色名
     */
    private String roleName;

    /**
     * Column: note
     * Type: VARCHAR(100)
     * Remark: 描述
     */
    private String note;

    /**
     * Column: order
     * Type: INT
     * Default value: 0
     * Remark: 顺序
     */
    private Integer order;
}