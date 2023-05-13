package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: pa_app_resource_id
 */
@Data
public class PaAppResourceId {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: resource_id
     * Type: VARCHAR(50)
     * Remark: 资源标识
     */
    private String resourceId;

    /**
     * Column: app_id
     * Type: VARCHAR(50)
     * Remark: 应用标识
     */
    private String appId;
}