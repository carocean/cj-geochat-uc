package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.middle.uc.mapper.SysPropsMapper;
import cj.geochat.middle.uc.model.SysProps;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static cj.geochat.middle.uc.mapper.SysPropsDynamicSqlSupport.id;
import static cj.geochat.middle.uc.mapper.SysPropsDynamicSqlSupport.sysProps;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Service
public class TestService {
    @Resource
    SysPropsMapper sysPropsMapper;

    @Transactional
    @DataSourceConfig.ReadOnly
    public List<SysProps> listProp() {
        SelectStatementProvider provider = SqlBuilder
                .select(sysProps.allColumns())
                .from(sysProps)
//                .where(id, isEqualTo(str))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return sysPropsMapper.selectMany(provider);
    }
    @Transactional
    public void save(SysProps props) {
//        props.setId("920390293203");
        sysPropsMapper.insert(props);
    }
}
