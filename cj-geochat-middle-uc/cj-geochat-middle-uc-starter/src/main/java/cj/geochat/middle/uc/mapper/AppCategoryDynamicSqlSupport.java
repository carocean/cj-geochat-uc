package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class AppCategoryDynamicSqlSupport {
    public static final AppCategory appCategory = new AppCategory();

    public static final SqlColumn<String> id = appCategory.id;

    public static final SqlColumn<String> cateCode = appCategory.cateCode;

    public static final SqlColumn<String> cateName = appCategory.cateName;

    public static final SqlColumn<String> cateDesc = appCategory.cateDesc;

    public static final SqlColumn<Integer> order = appCategory.order;

    public static final class AppCategory extends AliasableSqlTable<AppCategory> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> cateCode = column("cate_code", JDBCType.VARCHAR);

        public final SqlColumn<String> cateName = column("cate_name", JDBCType.VARCHAR);

        public final SqlColumn<String> cateDesc = column("cate_desc", JDBCType.VARCHAR);

        public final SqlColumn<Integer> order = column("`order`", JDBCType.INTEGER);

        public AppCategory() {
            super("app_category", AppCategory::new);
        }
    }
}