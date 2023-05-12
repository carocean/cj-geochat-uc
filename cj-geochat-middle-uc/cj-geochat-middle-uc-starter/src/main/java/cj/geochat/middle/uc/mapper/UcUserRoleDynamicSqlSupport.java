package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcUserRoleDynamicSqlSupport {
    public static final UcUserRole ucUserRole = new UcUserRole();

    public static final SqlColumn<String> id = ucUserRole.id;

    public static final SqlColumn<String> userId = ucUserRole.userId;

    public static final SqlColumn<String> roleId = ucUserRole.roleId;

    public static final class UcUserRole extends AliasableSqlTable<UcUserRole> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> roleId = column("role_id", JDBCType.VARCHAR);

        public UcUserRole() {
            super("uc_user_role", UcUserRole::new);
        }
    }
}