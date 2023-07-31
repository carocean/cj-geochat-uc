package cj.geochat.uc.middle.model;

import lombok.Data;

/**
 * Table: pa_app_authority
 */
@Data
public class PaAppAuthority {
    /**
     * Column: id
     * Type: VARCHAR(50)
     */
    private String id;

    /**
     * Column: role_id
     * Type: VARCHAR(50)
     */
    private String roleId;

    /**
     * Column: app_id
     * Type: VARCHAR(50)
     */
    private String appId;
}