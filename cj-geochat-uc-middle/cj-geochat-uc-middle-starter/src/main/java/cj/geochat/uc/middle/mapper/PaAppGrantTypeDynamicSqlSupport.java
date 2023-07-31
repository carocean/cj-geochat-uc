package cj.geochat.uc.middle.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class PaAppGrantTypeDynamicSqlSupport {
    public static final PaAppGrantType paAppGrantType = new PaAppGrantType();

    public static final SqlColumn<String> id = paAppGrantType.id;

    public static final SqlColumn<String> appId = paAppGrantType.appId;

    public static final SqlColumn<String> grantType = paAppGrantType.grantType;

    public static final class PaAppGrantType extends AliasableSqlTable<PaAppGrantType> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> appId = column("app_id", JDBCType.VARCHAR);

        public final SqlColumn<String> grantType = column("grant_type", JDBCType.VARCHAR);

        public PaAppGrantType() {
            super("pa_app_grant_type", PaAppGrantType::new);
        }
    }
}