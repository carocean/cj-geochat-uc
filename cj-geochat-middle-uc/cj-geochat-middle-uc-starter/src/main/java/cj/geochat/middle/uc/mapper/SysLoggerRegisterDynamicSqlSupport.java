package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SysLoggerRegisterDynamicSqlSupport {
    public static final SysLoggerRegister sysLoggerRegister = new SysLoggerRegister();

    public static final SqlColumn<String> id = sysLoggerRegister.id;

    public static final SqlColumn<String> eventType = sysLoggerRegister.eventType;

    public static final SqlColumn<String> eventTitle = sysLoggerRegister.eventTitle;

    public static final SqlColumn<String> userId = sysLoggerRegister.userId;

    public static final SqlColumn<String> accountId = sysLoggerRegister.accountId;

    public static final SqlColumn<String> accountCate = sysLoggerRegister.accountCate;

    public static final SqlColumn<Byte> sourceType = sysLoggerRegister.sourceType;

    public static final SqlColumn<String> sourceDesc = sysLoggerRegister.sourceDesc;

    public static final SqlColumn<String> message = sysLoggerRegister.message;

    public static final SqlColumn<String> status = sysLoggerRegister.status;

    public static final SqlColumn<String> deviceId = sysLoggerRegister.deviceId;

    public static final SqlColumn<String> ipAddress = sysLoggerRegister.ipAddress;

    public static final SqlColumn<String> regUsername = sysLoggerRegister.regUsername;

    public static final SqlColumn<String> regAccount = sysLoggerRegister.regAccount;

    public static final SqlColumn<String> avatar = sysLoggerRegister.avatar;

    public static final SqlColumn<String> city = sysLoggerRegister.city;

    public static final SqlColumn<String> regLanguage = sysLoggerRegister.regLanguage;

    public static final SqlColumn<String> ctime = sysLoggerRegister.ctime;

    public static final SqlColumn<Integer> year = sysLoggerRegister.year;

    public static final SqlColumn<Integer> month = sysLoggerRegister.month;

    public static final SqlColumn<Integer> day = sysLoggerRegister.day;

    public static final class SysLoggerRegister extends AliasableSqlTable<SysLoggerRegister> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> eventType = column("event_type", JDBCType.VARCHAR);

        public final SqlColumn<String> eventTitle = column("event_title", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> accountId = column("account_id", JDBCType.VARCHAR);

        public final SqlColumn<String> accountCate = column("account_cate", JDBCType.VARCHAR);

        public final SqlColumn<Byte> sourceType = column("source_type", JDBCType.TINYINT);

        public final SqlColumn<String> sourceDesc = column("source_desc", JDBCType.VARCHAR);

        public final SqlColumn<String> message = column("message", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("`status`", JDBCType.VARCHAR);

        public final SqlColumn<String> deviceId = column("device_id", JDBCType.VARCHAR);

        public final SqlColumn<String> ipAddress = column("ip_address", JDBCType.VARCHAR);

        public final SqlColumn<String> regUsername = column("reg_username", JDBCType.VARCHAR);

        public final SqlColumn<String> regAccount = column("reg_account", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> city = column("city", JDBCType.VARCHAR);

        public final SqlColumn<String> regLanguage = column("reg_language", JDBCType.VARCHAR);

        public final SqlColumn<String> ctime = column("ctime", JDBCType.VARCHAR);

        public final SqlColumn<Integer> year = column("`year`", JDBCType.INTEGER);

        public final SqlColumn<Integer> month = column("`month`", JDBCType.INTEGER);

        public final SqlColumn<Integer> day = column("`day`", JDBCType.INTEGER);

        public SysLoggerRegister() {
            super("sys_logger_register", SysLoggerRegister::new);
        }
    }
}