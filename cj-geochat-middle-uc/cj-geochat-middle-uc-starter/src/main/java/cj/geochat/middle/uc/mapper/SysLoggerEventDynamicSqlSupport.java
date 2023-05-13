package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class SysLoggerEventDynamicSqlSupport {
    public static final SysLoggerEvent sysLoggerEvent = new SysLoggerEvent();

    public static final SqlColumn<String> id = sysLoggerEvent.id;

    public static final SqlColumn<String> eventType = sysLoggerEvent.eventType;

    public static final SqlColumn<String> eventTitle = sysLoggerEvent.eventTitle;

    public static final SqlColumn<String> eventContent = sysLoggerEvent.eventContent;

    public static final SqlColumn<String> userId = sysLoggerEvent.userId;

    public static final SqlColumn<String> accountId = sysLoggerEvent.accountId;

    public static final SqlColumn<String> message = sysLoggerEvent.message;

    public static final SqlColumn<String> status = sysLoggerEvent.status;

    public static final SqlColumn<String> ctime = sysLoggerEvent.ctime;

    public static final class SysLoggerEvent extends AliasableSqlTable<SysLoggerEvent> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> eventType = column("event_type", JDBCType.VARCHAR);

        public final SqlColumn<String> eventTitle = column("event_title", JDBCType.VARCHAR);

        public final SqlColumn<String> eventContent = column("event_content", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> accountId = column("account_id", JDBCType.VARCHAR);

        public final SqlColumn<String> message = column("message", JDBCType.VARCHAR);

        public final SqlColumn<String> status = column("`status`", JDBCType.VARCHAR);

        public final SqlColumn<String> ctime = column("ctime", JDBCType.VARCHAR);

        public SysLoggerEvent() {
            super("sys_logger_event", SysLoggerEvent::new);
        }
    }
}