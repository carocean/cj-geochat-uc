package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class PaAppCapabilityDynamicSqlSupport {
    public static final PaAppCapability paAppCapability = new PaAppCapability();

    public static final SqlColumn<String> id = paAppCapability.id;

    public static final SqlColumn<String> appId = paAppCapability.appId;

    public static final SqlColumn<String> abilityId = paAppCapability.abilityId;

    public static final class PaAppCapability extends AliasableSqlTable<PaAppCapability> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> appId = column("app_id", JDBCType.VARCHAR);

        public final SqlColumn<String> abilityId = column("ability_id", JDBCType.VARCHAR);

        public PaAppCapability() {
            super("pa_app_capability", PaAppCapability::new);
        }
    }
}