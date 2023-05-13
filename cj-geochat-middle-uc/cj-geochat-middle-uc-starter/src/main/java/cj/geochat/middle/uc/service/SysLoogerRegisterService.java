package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.middle.uc.LoggerEventType;
import cj.geochat.middle.uc.mapper.SysLoggerRegisterDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.SysLoggerRegisterMapper;
import cj.geochat.middle.uc.model.SysLoggerRegister;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SysLoogerRegisterService implements ISysLoggerRegisterService {
    @Autowired
    SysLoggerRegisterMapper loggerRegisterMapper;

    @Transactional
    @Override
    public void logger(SysLoggerRegister loggerRegister) {
        if (!StringUtils.hasText(loggerRegister.getId())) {
            loggerRegister.setId(UlidCreator.getUlid().toLowerCase());
        }
        loggerRegisterMapper.insertSelective(loggerRegister);
    }

    @Transactional
    @Override
    public void remove(String beginTime, String endTime) {
        loggerRegisterMapper.delete(c -> c
                .where(SysLoggerRegisterDynamicSqlSupport.ctime, SqlBuilder.isGreaterThanOrEqualTo(beginTime))
                .and(SysLoggerRegisterDynamicSqlSupport.ctime, SqlBuilder.isLessThanOrEqualTo(endTime))
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<SysLoggerRegister> listLogger(long limit, long offset) {
        return loggerRegisterMapper.select(c -> c
                .orderBy(SysLoggerRegisterDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<SysLoggerRegister> listLoggerByUser(String userId, long limit, long offset) {
        return loggerRegisterMapper.select(c -> c
                .where(SysLoggerRegisterDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                .orderBy(SysLoggerRegisterDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<SysLoggerRegister> listLoggerByType(LoggerEventType eventType, long limit, long offset) {
        return loggerRegisterMapper.select(c -> c
                .where(SysLoggerRegisterDynamicSqlSupport.eventType, SqlBuilder.isEqualTo(eventType.name()))
                .orderBy(SysLoggerRegisterDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<SysLoggerRegister> listLoggerByTime(String beginTime, String endTime, long limit, long offset) {
        return loggerRegisterMapper.select(c -> c
                .where(SysLoggerRegisterDynamicSqlSupport.ctime, SqlBuilder.isGreaterThanOrEqualTo(beginTime))
                .and(SysLoggerRegisterDynamicSqlSupport.ctime, SqlBuilder.isLessThanOrEqualTo(endTime))
                .orderBy(SysLoggerRegisterDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public SysLoggerRegister getLogger(String id) {
        return loggerRegisterMapper.selectByPrimaryKey(id).orElse(null);
    }
}
