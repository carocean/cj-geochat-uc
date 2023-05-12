package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcLoggerRegisterDynamicSqlSupport {
    public static final UcLoggerRegister ucLoggerRegister = new UcLoggerRegister();

    public static final SqlColumn<String> id = ucLoggerRegister.id;

    public static final SqlColumn<Byte> eventType = ucLoggerRegister.eventType;

    public static final SqlColumn<String> eventTitle = ucLoggerRegister.eventTitle;

    public static final SqlColumn<String> userId = ucLoggerRegister.userId;

    public static final SqlColumn<String> accountId = ucLoggerRegister.accountId;

    public static final SqlColumn<Boolean> accountCate = ucLoggerRegister.accountCate;

    public static final SqlColumn<Byte> sourceType = ucLoggerRegister.sourceType;

    public static final SqlColumn<String> sourceDesc = ucLoggerRegister.sourceDesc;

    public static final SqlColumn<String> message = ucLoggerRegister.message;

    public static final SqlColumn<String> status = ucLoggerRegister.status;

    public static final SqlColumn<String> ipAddress = ucLoggerRegister.ipAddress;

    public static final SqlColumn<String> osPlatform = ucLoggerRegister.osPlatform;

    public static final SqlColumn<String> regUsername = ucLoggerRegister.regUsername;

    public static final SqlColumn<String> regAccount = ucLoggerRegister.regAccount;

    public static final SqlColumn<String> avatar = ucLoggerRegister.avatar;

    public static final SqlColumn<String> city = ucLoggerRegister.city;

    public static final SqlColumn<String> regLanguage = ucLoggerRegister.regLanguage;

    public static final SqlColumn<String> ctime = ucLoggerRegister.ctime;

    public static final SqlColumn<Integer> year = ucLoggerRegister.year;

    public static final SqlColumn<Integer> month = ucLoggerRegister.month;

    public static final SqlColumn<Integer> day = ucLoggerRegister.day;

    public static final class UcLoggerRegister extends AliasableSqlTable<UcLoggerRegister> {
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

        public final SqlColumn<String> regUsername = column("reg_username", JDBCType.VARCHAR);

        public final SqlColumn<String> regAccount = column("reg_account", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> city = column("city", JDBCType.VARCHAR);

        public final SqlColumn<String> regLanguage = column("reg_language", JDBCType.VARCHAR);

        public final SqlColumn<String> ctime = column("ctime", JDBCType.VARCHAR);

        public final SqlColumn<Integer> year = column("`year`", JDBCType.INTEGER);

        public final SqlColumn<Integer> month = column("`month`", JDBCType.INTEGER);

        public final SqlColumn<Integer> day = column("`day`", JDBCType.INTEGER);

        public UcLoggerRegister() {
            super("uc_logger_register", UcLoggerRegister::new);
        }
    }
}