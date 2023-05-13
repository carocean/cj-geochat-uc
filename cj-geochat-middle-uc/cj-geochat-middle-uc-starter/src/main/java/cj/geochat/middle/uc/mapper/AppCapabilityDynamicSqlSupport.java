package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class AppCapabilityDynamicSqlSupport {
    public static final AppCapability appCapability = new AppCapability();

    public static final SqlColumn<String> id = appCapability.id;

    public static final SqlColumn<String> abilityCode = appCapability.abilityCode;

    public static final SqlColumn<String> abilityName = appCapability.abilityName;

    public static final SqlColumn<String> abilityDesc = appCapability.abilityDesc;

    public static final SqlColumn<Integer> order = appCapability.order;

    public static final class AppCapability extends AliasableSqlTable<AppCapability> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> abilityCode = column("ability_code", JDBCType.VARCHAR);

        public final SqlColumn<String> abilityName = column("ability_name", JDBCType.VARCHAR);

        public final SqlColumn<String> abilityDesc = column("ability_desc", JDBCType.VARCHAR);

        public final SqlColumn<Integer> order = column("`order`", JDBCType.INTEGER);

        public AppCapability() {
            super("app_capability", AppCapability::new);
        }
    }
}