package cj.geochat.uc.middle.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SysLoggerLoginDynamicSqlSupport {
    public static final SysLoggerLogin sysLoggerLogin = new SysLoggerLogin();

    public static final SqlColumn<String> id = sysLoggerLogin.id;

    public static final SqlColumn<String> eventType = sysLoggerLogin.eventType;

    public static final SqlColumn<String> eventTitle = sysLoggerLogin.eventTitle;

    public static final SqlColumn<String> userId = sysLoggerLogin.userId;

    public static final SqlColumn<String> accountId = sysLoggerLogin.accountId;

    public static final SqlColumn<Boolean> accountCate = sysLoggerLogin.accountCate;

    public static final SqlColumn<Byte> sourceType = sysLoggerLogin.sourceType;

    public static final SqlColumn<String> sourceDesc = sysLoggerLogin.sourceDesc;

    public static final SqlColumn<String> message = sysLoggerLogin.message;

    public static final SqlColumn<String> status = sysLoggerLogin.status;

    public static final SqlColumn<String> ipAddress = sysLoggerLogin.ipAddress;

    public static final SqlColumn<String> deviceId = sysLoggerLogin.deviceId;

    public static final SqlColumn<String> ctime = sysLoggerLogin.ctime;

    public static final SqlColumn<Integer> year = sysLoggerLogin.year;

    public static final SqlColumn<Integer> month = sysLoggerLogin.month;

    public static final SqlColumn<Integer> day = sysLoggerLogin.day;

    public static final class SysLoggerLogin extends AliasableSqlTable<SysLoggerLogin> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> eventType = column("event_type", JDBCType.VARCHAR);

        public final SqlColumn<String> eventTitle = column("event_title", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> accountId = column("account_id", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> accountCate = column("account_cate", JDBCType.BIT);

        public final SqlColumn<Byte> sourceType = column("source_type", JDBCType.TINYINT);

        public final SqlColumn<String> sourceDesc = column("source_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> message = column("message", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("`status`", JDBCType.VARCHAR);

        public final SqlColumn<String> ipAddress = column("ip_address", JDBCType.VARCHAR);

        public final SqlColumn<String> deviceId = column("device_id", JDBCType.VARCHAR);

        public final SqlColumn<String> ctime = column("ctime", JDBCType.VARCHAR);

        public final SqlColumn<Integer> year = column("`year`", JDBCType.INTEGER);

        public final SqlColumn<Integer> month = column("`month`", JDBCType.INTEGER);

        public final SqlColumn<Integer> day = column("`day`", JDBCType.INTEGER);

        public SysLoggerLogin() {
            super("sys_logger_login", SysLoggerLogin::new);
        }
    }
}