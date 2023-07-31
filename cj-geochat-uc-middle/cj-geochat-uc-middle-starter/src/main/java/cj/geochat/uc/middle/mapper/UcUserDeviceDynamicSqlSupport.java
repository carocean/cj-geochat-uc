package cj.geochat.uc.middle.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcUserDeviceDynamicSqlSupport {
    public static final UcUserDevice ucUserDevice = new UcUserDevice();

    public static final SqlColumn<String> id = ucUserDevice.id;

    public static final SqlColumn<String> userId = ucUserDevice.userId;

    public static final SqlColumn<String> identifier = ucUserDevice.identifier;

    public static final SqlColumn<String> osName = ucUserDevice.osName;

    public static final SqlColumn<String> deviceName = ucUserDevice.deviceName;

    public static final SqlColumn<String> deviceVersion = ucUserDevice.deviceVersion;

    public static final class UcUserDevice extends AliasableSqlTable<UcUserDevice> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> identifier = column("identifier", JDBCType.VARCHAR);

        public final SqlColumn<String> osName = column("os_name", JDBCType.VARCHAR);

        public final SqlColumn<String> deviceName = column("device_name", JDBCType.VARCHAR);

        public final SqlColumn<String> deviceVersion = column("device_version", JDBCType.VARCHAR);

        public UcUserDevice() {
            super("uc_user_device", UcUserDevice::new);
        }
    }
}