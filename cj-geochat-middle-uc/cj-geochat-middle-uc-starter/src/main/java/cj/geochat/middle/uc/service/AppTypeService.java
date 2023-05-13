package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.middle.uc.mapper.AppTypeMapper;
import cj.geochat.middle.uc.model.AppType;
import com.github.f4b6a3.ulid.UlidCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AppTypeService implements IAppTypeService {
    @Autowired
    AppTypeMapper appTypeMapper;

    @Transactional
    @Override
    public String createAppType(String code, String name, String desc) {
        AppType type = new AppType();
        type.setId(UlidCreator.getUlid().toLowerCase());
        type.setTypeCode(code);
        type.setTypeName(name);
        type.setTypeDesc(desc);
        appTypeMapper.insertSelective(type);
        return type.getId();
    }

    @Transactional
    @Override
    public void removeAppType(String id) {
        appTypeMapper.deleteByPrimaryKey(id);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public AppType getAppType(String id) {
        return appTypeMapper.selectByPrimaryKey(id).orElse(null);
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<AppType> listAppType() {
        return appTypeMapper.select(c -> c);
    }
}
