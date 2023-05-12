package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcLoggerLoginDynamicSqlSupport {
    public static final UcLoggerLogin ucLoggerLogin = new UcLoggerLogin();

    public static final SqlColumn<String> id = ucLoggerLogin.id;

    public static final SqlColumn<Byte> eventType = ucLoggerLogin.eventType;

    public static final SqlColumn<String> eventTitle = ucLoggerLogin.eventTitle;

    public static final SqlColumn<String> userId = ucLoggerLogin.userId;

    public static final SqlColumn<String> accountId = ucLoggerLogin.accountId;

    public static final SqlColumn<Boolean> accountCate = ucLoggerLogin.accountCate;

    public static final SqlColumn<Byte> sourceType = ucLoggerLogin.sourceType;

    public static final SqlColumn<String> sourceDesc = ucLoggerLogin.sourceDesc;

    public static final SqlColumn<String> message = ucLoggerLogin.message;

    public static final SqlColumn<String> status = ucLoggerLogin.status;

    public static final SqlColumn<String> ipAddress = ucLoggerLogin.ipAddress;

    public static final SqlColumn<String> osPlatform = ucLoggerLogin.osPlatform;

    public static final SqlColumn<String> ctime = ucLoggerLogin.ctime;

    public static final SqlColumn<Integer> year = ucLoggerLogin.year;

    public static final SqlColumn<Integer> month = ucLoggerLogin.month;

    public static final SqlColumn<Integer> day = ucLoggerLogin.day;

    public static final class UcLoggerLogin extends AliasableSqlTable<UcLoggerLogin> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<Byte> eventType = column("event_type", JDBCType.TINYINT);

        public final SqlColumn<String> eventTitle = column("event_title", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> accountId = column("account_id", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> accountCate = column("account_cate", JDBCType.BIT);

        public final SqlColumn<Byte> sourceType = column("source_type", JDBCType.TINYINT);

        public final SqlColumn<String> sourceDesc = column("source_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> message = column("message", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("`status`", JDBCType.VARCHAR);

        public final SqlColumn<String> ipAddress = column("ip_address", JDBCType.VARCHAR);

        public final SqlColumn<String> osPlatform = column("os_platform", JDBCType.VARCHAR);

        public final SqlColumn<String> ctime = column("ctime", JDBCType.VARCHAR);

        public final SqlColumn<Integer> year = column("`year`", JDBCType.INTEGER);

        public final SqlColumn<Integer> month = column("`month`", JDBCType.INTEGER);

        public final SqlColumn<Integer> day = column("`day`", JDBCType.INTEGER);

        public UcLoggerLogin() {
            super("uc_logger_login", UcLoggerLogin::new);
        }
    }
}