package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.uc.middle.mapper.SysPropsDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.SysPropsMapper;
import cj.geochat.uc.middle.model.SysProps;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SysPropertyService implements ISysPropertyService {
    @Autowired
    SysPropsMapper propsMapper;

    @Transactional
    @Override
    public void removeById(String id) {
        propsMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public void remove(String map, String key) {
        propsMapper.delete(c -> c
                .where(SysPropsDynamicSqlSupport.map, SqlBuilder.isEqualTo(map))
                .and(SysPropsDynamicSqlSupport.key, SqlBuilder.isEqualTo(key))
        );
    }

    @Transactional
    @Override
    public void put(String map, String key, String value, String note) {
        remove(map, key);
        SysProps props = new SysProps();
        props.setId(UlidCreator.getUlid().toLowerCase());
        props.setMap(map);
        props.setKey(key);
        props.setValue(value);
        props.setNote(note);
        propsMapper.insertSelective(props);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public SysProps getProperty(String id) {
        return propsMapper.selectByPrimaryKey(id).orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public SysProps getProperty(String map, String key) {
        return propsMapper.select(c -> c
                .where(SysPropsDynamicSqlSupport.map, SqlBuilder.isEqualTo(map))
                .and(SysPropsDynamicSqlSupport.key, SqlBuilder.isEqualTo(key))
                .limit(1)
        ).stream().findAny().orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public String getValue(String map, String key) {
        return propsMapper.selectMany(SqlBuilder.select(SysPropsDynamicSqlSupport.sysProps.allColumns())
                .from(SysPropsDynamicSqlSupport.sysProps)
                .where(SysPropsDynamicSqlSupport.map, SqlBuilder.isEqualTo(map))
                .and(SysPropsDynamicSqlSupport.key, SqlBuilder.isEqualTo(key))
                .limit(1)
                .build().render(RenderingStrategies.MYBATIS3)
        ).stream().map(e -> e.getValue()).findAny().orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public String getNote(String map, String key) {
        return propsMapper.selectMany(SqlBuilder.select(SysPropsDynamicSqlSupport.sysProps.allColumns())
                .from(SysPropsDynamicSqlSupport.sysProps)
                .where(SysPropsDynamicSqlSupport.map, SqlBuilder.isEqualTo(map))
                .and(SysPropsDynamicSqlSupport.key, SqlBuilder.isEqualTo(key))
                .limit(1)
                .build().render(RenderingStrategies.MYBATIS3)
        ).stream().map(e -> e.getNote()).findAny().orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<SysProps> listProperty(int limit, long offset) {
        return propsMapper.select(c -> c
                .limit(limit).offset(offset)
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<SysProps> listByMap(String map) {
        return propsMapper.select(dsl -> dsl
                .where(SysPropsDynamicSqlSupport.map, SqlBuilder.isEqualTo(map))
        );
    }

    @Transactional
    @Override
    public void emptyMap(String map) {
        propsMapper.delete(c -> c
                .where(SysPropsDynamicSqlSupport.map, SqlBuilder.isEqualTo(map))
        );
    }
}
