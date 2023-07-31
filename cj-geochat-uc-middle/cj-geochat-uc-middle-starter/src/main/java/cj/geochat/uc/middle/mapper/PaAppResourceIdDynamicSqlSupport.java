package cj.geochat.uc.middle.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class PaAppResourceIdDynamicSqlSupport {
    public static final PaAppResourceId paAppResourceId = new PaAppResourceId();

    public static final SqlColumn<String> id = paAppResourceId.id;

    public static final SqlColumn<String> resourceId = paAppResourceId.resourceId;

    public static final SqlColumn<String> appId = paAppResourceId.appId;

    public static final class PaAppResourceId extends AliasableSqlTable<PaAppResourceId> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> resourceId = column("resource_id", JDBCType.VARCHAR);

        public final SqlColumn<String> appId = column("app_id", JDBCType.VARCHAR);

        public PaAppResourceId() {
            super("pa_app_resource_id", PaAppResourceId::new);
        }
    }
}