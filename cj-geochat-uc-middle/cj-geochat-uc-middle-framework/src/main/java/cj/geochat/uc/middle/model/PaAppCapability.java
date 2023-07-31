package cj.geochat.uc.middle.model;

import lombok.Data;

/**
 * Table: pa_app_capability
 */
@Data
public class PaAppCapability {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: app_id
     * Type: VARCHAR(50)
     * Remark: 应用标识
     */
    private String appId;

    /**
     * Column: ability_id
     * Type: VARCHAR(50)
     * Remark: 能力标识
     */
    private String abilityId;
}