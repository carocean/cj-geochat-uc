package cj.geochat.uc.middle.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class AppResourceIdDynamicSqlSupport {
    public static final AppResourceId appResourceId = new AppResourceId();

    public static final SqlColumn<String> id = appResourceId.id;

    public static final SqlColumn<String> resourceCode = appResourceId.resourceCode;

    public static final SqlColumn<String> resourceTitle = appResourceId.resourceTitle;

    public static final SqlColumn<String> resourceDesc = appResourceId.resourceDesc;

    public static final class AppResourceId extends AliasableSqlTable<AppResourceId> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> resourceCode = column("resource_code", JDBCType.VARCHAR);

        public final SqlColumn<String> resourceTitle = column("resource_title", JDBCType.VARCHAR);

        public final SqlColumn<String> resourceDesc = column("resource_desc", JDBCType.VARCHAR);

        public AppResourceId() {
            super("app_resource_id", AppResourceId::new);
        }
    }
}