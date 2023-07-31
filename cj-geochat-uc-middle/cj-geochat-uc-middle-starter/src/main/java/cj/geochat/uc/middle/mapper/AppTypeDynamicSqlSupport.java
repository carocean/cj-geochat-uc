package cj.geochat.uc.middle.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class AppTypeDynamicSqlSupport {
    public static final AppType appType = new AppType();

    public static final SqlColumn<String> id = appType.id;

    public static final SqlColumn<String> typeCode = appType.typeCode;

    public static final SqlColumn<String> typeName = appType.typeName;

    public static final SqlColumn<String> typeDesc = appType.typeDesc;

    public static final class AppType extends AliasableSqlTable<AppType> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> typeCode = column("type_code", JDBCType.VARCHAR);

        public final SqlColumn<String> typeName = column("type_name", JDBCType.VARCHAR);

        public final SqlColumn<String> typeDesc = column("type_desc", JDBCType.VARCHAR);

        public AppType() {
            super("app_type", AppType::new);
        }
    }
}