package cj.geochat.middle.uc.model;

import lombok.Data;

/**
 * Table: app_category
 */
@Data
public class AppCategory {
    /**
     * Column: id
     * Type: VARCHAR(50)
     * Remark: 标识
     */
    private String id;

    /**
     * Column: cate_code
     * Type: VARCHAR(40)
     * Remark: 类别代码
     */
    private String cateCode;

    /**
     * Column: cate_name
     * Type: VARCHAR(40)
     * Remark: 类别名称
     */
    private String cateName;

    /**
     * Column: cate_desc
     * Type: VARCHAR(100)
     * Remark: 类别描述
     */
    private String cateDesc;

    /**
     * Column: order
     * Type: INT
     * Remark: 顺序
     */
    private Integer order;
}