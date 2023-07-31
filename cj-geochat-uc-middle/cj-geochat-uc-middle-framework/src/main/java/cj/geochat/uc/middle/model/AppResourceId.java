package cj.geochat.uc.middle.model;

import lombok.Data;

/**
 * Table: app_resource_id
 */
@Data
public class AppResourceId {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: resource_code
     * Type: VARCHAR(100)
     * Remark: 微服务的英文名，即在eureka中的可访问名字)
     */
    private String resourceCode;

    /**
     * Column: resource_title
     * Type: VARCHAR(40)
     * Remark: 微服务中文名
     */
    private String resourceTitle;

    /**
     * Column: resource_desc
     * Type: VARCHAR(100)
     * Remark: 微服务描述
     */
    private String resourceDesc;
}