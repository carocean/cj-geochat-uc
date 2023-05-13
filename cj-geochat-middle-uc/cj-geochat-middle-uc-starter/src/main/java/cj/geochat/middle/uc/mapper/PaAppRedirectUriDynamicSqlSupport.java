package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class PaAppRedirectUriDynamicSqlSupport {
    public static final PaAppRedirectUri paAppRedirectUri = new PaAppRedirectUri();

    public static final SqlColumn<String> id = paAppRedirectUri.id;

    public static final SqlColumn<String> appId = paAppRedirectUri.appId;

    public static final SqlColumn<String> redirectUri = paAppRedirectUri.redirectUri;

    public static final class PaAppRedirectUri extends AliasableSqlTable<PaAppRedirectUri> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> appId = column("app_id", JDBCType.VARCHAR);

        public final SqlColumn<String> redirectUri = column("redirect_uri", JDBCType.VARCHAR);

        public PaAppRedirectUri() {
            super("pa_app_redirect_uri", PaAppRedirectUri::new);
        }
    }
}