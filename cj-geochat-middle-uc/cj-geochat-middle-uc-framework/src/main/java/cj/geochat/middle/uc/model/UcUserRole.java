package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: uc_user_role
 */
@Data
public class UcUserRole {
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
     * Column: role_id
     * Type: VARCHAR(50)
     * Remark: 角色标识
     */
    private String roleId;
}