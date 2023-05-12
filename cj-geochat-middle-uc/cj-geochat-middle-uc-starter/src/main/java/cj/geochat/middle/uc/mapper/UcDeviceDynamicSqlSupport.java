package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcDeviceDynamicSqlSupport {
    public static final UcDevice ucDevice = new UcDevice();

    public static final SqlColumn<String> id = ucDevice.id;

    public static final SqlColumn<String> identifier = ucDevice.identifier;

    public static final SqlColumn<String> osName = ucDevice.osName;

    public static final SqlColumn<String> deviceName = ucDevice.deviceName;

    public static final SqlColumn<String> deviceVersion = ucDevice.deviceVersion;

    public static final class UcDevice extends AliasableSqlTable<UcDevice> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> identifier = column("identifier", JDBCType.VARCHAR);

        public final SqlColumn<String> osName = column("os_name", JDBCType.VARCHAR);

        public final SqlColumn<String> deviceName = column("device_name", JDBCType.VARCHAR);

        public final SqlColumn<String> deviceVersion = column("device_version", JDBCType.VARCHAR);

        public UcDevice() {
            super("uc_device", UcDevice::new);
        }
    }
}