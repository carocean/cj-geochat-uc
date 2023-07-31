package cj.geochat.uc.middle.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class ApplicationDynamicSqlSupport {
    public static final Application application = new Application();

    public static final SqlColumn<String> id = application.id;

    public static final SqlColumn<String> appKey = application.appKey;

    public static final SqlColumn<String> appKeyIssuedAt = application.appKeyIssuedAt;

    public static final SqlColumn<String> appSecret = application.appSecret;

    public static final SqlColumn<String> appSecretIssuedAt = application.appSecretIssuedAt;

    public static final SqlColumn<String> appName = application.appName;

    public static final SqlColumn<String> typeId = application.typeId;

    public static final SqlColumn<String> cateId = application.cateId;

    public static final SqlColumn<Boolean> autoapprove = application.autoapprove;

    public static final SqlColumn<Long> refreshTokenValidity = application.refreshTokenValidity;

    public static final SqlColumn<Long> authCodeValidity = application.authCodeValidity;

    public static final SqlColumn<Long> accessTokenValidity = application.accessTokenValidity;

    public static final SqlColumn<Boolean> reuseRefreshTokens = application.reuseRefreshTokens;

    public static final class Application extends AliasableSqlTable<Application> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> appKey = column("app_key", JDBCType.VARCHAR);

        public final SqlColumn<String> appKeyIssuedAt = column("app_key_issued_at", JDBCType.VARCHAR);

        public final SqlColumn<String> appSecret = column("app_secret", JDBCType.VARCHAR);

        public final SqlColumn<String> appSecretIssuedAt = column("app_secret_issued_at", JDBCType.VARCHAR);

        public final SqlColumn<String> appName = column("app_name", JDBCType.VARCHAR);

        public final SqlColumn<String> typeId = column("type_id", JDBCType.VARCHAR);

        public final SqlColumn<String> cateId = column("cate_id", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> autoapprove = column("autoapprove", JDBCType.BIT);

        public final SqlColumn<Long> refreshTokenValidity = column("refresh_token_validity", JDBCType.BIGINT);

        public final SqlColumn<Long> authCodeValidity = column("auth_code_validity", JDBCType.BIGINT);

        public final SqlColumn<Long> accessTokenValidity = column("access_token_validity", JDBCType.BIGINT);

        public final SqlColumn<Boolean> reuseRefreshTokens = column("reuse_refresh_tokens", JDBCType.BIT);

        public Application() {
            super("application", Application::new);
        }
    }
}