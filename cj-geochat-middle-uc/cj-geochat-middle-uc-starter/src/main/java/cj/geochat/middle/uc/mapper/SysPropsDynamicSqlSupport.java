package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SysPropsDynamicSqlSupport {
    public static final SysProps sysProps = new SysProps();

    public static final SqlColumn<String> id = sysProps.id;

    public static final SqlColumn<String> map = sysProps.map;

    public static final SqlColumn<String> key = sysProps.key;

    public static final SqlColumn<String> value = sysProps.value;

    public static final SqlColumn<String> note = sysProps.note;

    public static final class SysProps extends AliasableSqlTable<SysProps> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> map = column("`map`", JDBCType.VARCHAR);

        public final SqlColumn<String> key = column("`key`", JDBCType.VARCHAR);

        public final SqlColumn<String> value = column("`value`", JDBCType.VARCHAR);

        public final SqlColumn<String> note = column("note", JDBCType.VARCHAR);

        public SysProps() {
            super("sys_props", SysProps::new);
        }
    }
}