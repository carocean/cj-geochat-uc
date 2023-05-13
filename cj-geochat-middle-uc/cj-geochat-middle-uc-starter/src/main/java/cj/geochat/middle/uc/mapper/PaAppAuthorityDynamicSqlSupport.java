package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class PaAppAuthorityDynamicSqlSupport {
    public static final PaAppAuthority paAppAuthority = new PaAppAuthority();

    public static final SqlColumn<String> id = paAppAuthority.id;

    public static final SqlColumn<String> roleId = paAppAuthority.roleId;

    public static final SqlColumn<String> appId = paAppAuthority.appId;

    public static final class PaAppAuthority extends AliasableSqlTable<PaAppAuthority> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> roleId = column("role_id", JDBCType.VARCHAR);

        public final SqlColumn<String> appId = column("app_id", JDBCType.VARCHAR);

        public PaAppAuthority() {
            super("pa_app_authority", PaAppAuthority::new);
        }
    }
}