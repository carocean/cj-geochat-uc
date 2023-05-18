package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.middle.uc.mapper.UcUserDeviceDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.UcUserDeviceMapper;
import cj.geochat.middle.uc.model.UcUserDevice;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserDeviceService implements IUserDeviceService {
    @Autowired
    UcUserDeviceMapper userDeviceMapper;

    @Transactional
    @Override
    public String createDevice(String userId, String identifier, String osName, String deviceName, String deviceVersion) {
        UcUserDevice device = new UcUserDevice();
        device.setId(UlidCreator.getUlid().toLowerCase());
        device.setIdentifier(identifier);
        device.setUserId(userId);
        device.setDeviceName(deviceName);
        device.setOsName(osName);
        device.setDeviceVersion(deviceVersion);
        userDeviceMapper.insertSelective(device);
        return device.getId();
    }

    @Transactional
    @Override
    public void removeDevice(String deviceId) {
        userDeviceMapper.deleteByPrimaryKey(deviceId);
    }

    @Transactional
    @Override
    public UcUserDevice getDevice(String deviceId) {
        return userDeviceMapper.selectByPrimaryKey(deviceId).orElse(null);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public UcUserDevice findDevice(String userId, String identifier) {
        return userDeviceMapper.select(c -> c
                .where(UcUserDeviceDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                .and(UcUserDeviceDynamicSqlSupport.identifier, SqlBuilder.isEqualTo(identifier))
        ).stream().findFirst().orElse(null);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<UcUserDevice> listDeviceOfUser(String userId) {
        return userDeviceMapper.select(c -> c
                .where(UcUserDeviceDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void removeDeviceOfUser(String userId, String identifier) {
        userDeviceMapper.delete(c -> c
                .where(UcUserDeviceDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                .and(UcUserDeviceDynamicSqlSupport.identifier, SqlBuilder.isEqualTo(identifier))
        );
    }

    @Transactional
    @Override
    public void emptyDeviceOfUser(String userId) {
        userDeviceMapper.delete(c -> c
                .where(UcUserDeviceDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
        );
    }
}
