package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.middle.uc.mapper.UcDeviceDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.UcDeviceMapper;
import cj.geochat.middle.uc.mapper.UcUserDeviceDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.UcUserDeviceMapper;
import cj.geochat.middle.uc.model.UcDevice;
import cj.geochat.middle.uc.model.UcUserDevice;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DeviceService implements IDeviceService {
    @Autowired
    UcDeviceMapper deviceMapper;
    @Autowired
    UcUserDeviceMapper ucUserDeviceMapper;

    @Transactional
    @Override
    public String createDevice(String identifier, String osName, String deviceName, String deviceVersion) {
        UcDevice device = new UcDevice();
        device.setId(UlidCreator.getUlid().toLowerCase());
        device.setIdentifier(identifier);
        device.setOsName(osName);
        device.setDeviceVersion(deviceVersion);
        deviceMapper.insertSelective(device);
        return device.getId();
    }

    @Transactional
    @Override
    public void removeDevice(String deviceId) {
        deviceMapper.deleteByPrimaryKey(deviceId);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public UcDevice getDevice(String deviceId) {
        return deviceMapper.selectByPrimaryKey(deviceId).orElse(null);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public UcDevice findDevice(String identifier) {
        return deviceMapper.select(c -> c
                .where(UcDeviceDynamicSqlSupport.identifier, SqlBuilder.isEqualTo(identifier))
                .limit(1)
        ).stream().findAny().orElse(null);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<UcDevice> listDevice(int limit, long offset) {
        return deviceMapper.select(c -> c
                .limit(limit).offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<UcDevice> listDevice(String os_name, int limit, long offset) {
        return deviceMapper.select(c -> c
                .where(UcDeviceDynamicSqlSupport.osName, SqlBuilder.isEqualTo(os_name))
                .limit(limit).offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<UcDevice> listDeviceOfUser(String userId) {
        return deviceMapper.selectMany(SqlBuilder
                .select(UcDeviceDynamicSqlSupport.ucDevice.allColumns())
                .from(UcDeviceDynamicSqlSupport.ucDevice)
                .join(UcUserDeviceDynamicSqlSupport.ucUserDevice)
                .on(UcUserDeviceDynamicSqlSupport.deviceId, SqlBuilder.equalTo(UcDeviceDynamicSqlSupport.id))
                .where(UcUserDeviceDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );
    }

    @Transactional
    @Override
    public void removeDeviceOfUser(String deviceId, String userId) {
        ucUserDeviceMapper.delete(c -> c
                .where(UcUserDeviceDynamicSqlSupport.deviceId, SqlBuilder.isEqualTo(deviceId))
                .and(UcUserDeviceDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void emptyDeviceOfUser(String userId) {
        ucUserDeviceMapper.delete(c -> c
                .where(UcUserDeviceDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void emptyUserOfDevice(String deviceId) {
        ucUserDeviceMapper.delete(c -> c
                .where(UcUserDeviceDynamicSqlSupport.deviceId, SqlBuilder.isEqualTo(deviceId))
        );
    }

    @Transactional
    @Override
    public void addDeviceToUser(String deviceId, String userId) {
        UcUserDevice ucUserDevice = new UcUserDevice();
        ucUserDevice.setId(UlidCreator.getUlid().toLowerCase());
        ucUserDevice.setDeviceId(deviceId);
        ucUserDevice.setUserId(userId);
        ucUserDeviceMapper.insertSelective(ucUserDevice);
    }
}
