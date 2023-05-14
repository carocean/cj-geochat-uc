package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcRoleDynamicSqlSupport {
    public static final UcRole ucRole = new UcRole();

    public static final SqlColumn<String> id = ucRole.id;

    public static final SqlColumn<String> roleCode = ucRole.roleCode;

    public static final SqlColumn<String> roleName = ucRole.roleName;

    public static final SqlColumn<String> note = ucRole.note;

    public static final SqlColumn<Integer> order = ucRole.order;

    public static final class UcRole extends AliasableSqlTable<UcRole> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> roleCode = column("role_code", JDBCType.VARCHAR);

        public final SqlColumn<String> roleName = column("role_name", JDBCType.VARCHAR);

        public final SqlColumn<String> note = column("note", JDBCType.VARCHAR);

        public final SqlColumn<Integer> order = column("`order`", JDBCType.INTEGER);

        public UcRole() {
            super("uc_role", UcRole::new);
        }
    }
}