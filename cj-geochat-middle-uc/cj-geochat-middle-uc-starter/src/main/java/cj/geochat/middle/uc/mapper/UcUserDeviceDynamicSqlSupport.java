package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcUserDeviceDynamicSqlSupport {
    public static final UcUserDevice ucUserDevice = new UcUserDevice();

    public static final SqlColumn<String> id = ucUserDevice.id;

    public static final SqlColumn<String> userId = ucUserDevice.userId;

    public static final SqlColumn<String> deviceId = ucUserDevice.deviceId;

    public static final class UcUserDevice extends AliasableSqlTable<UcUserDevice> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> deviceId = column("device_id", JDBCType.VARCHAR);

        public UcUserDevice() {
            super("uc_user_device", UcUserDevice::new);
        }
    }
}