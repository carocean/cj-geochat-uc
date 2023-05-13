package cj.geochat.middle.uc.service;

import cj.geochat.ability.mybatis.config.DataSourceConfig;
import cj.geochat.middle.uc.LoggerEventType;
import cj.geochat.middle.uc.mapper.SysLoggerEventDynamicSqlSupport;
import cj.geochat.middle.uc.mapper.SysLoggerEventMapper;
import cj.geochat.middle.uc.model.SysLoggerEvent;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SysLoggerEventService implements ISysLoggerEventService {
    @Autowired
    SysLoggerEventMapper loggerEventMapper;

    @Transactional
    @Override
    public void logger(SysLoggerEvent loggerEvent) {
        if (!StringUtils.hasText(loggerEvent.getId())) {
            loggerEvent.setId(UlidCreator.getUlid().toLowerCase());
        }
        loggerEventMapper.insertSelective(loggerEvent);
    }

    @Transactional
    @Override
    public void remove(String beginTime, String endTime) {
        loggerEventMapper.delete(c -> c
                .where(SysLoggerEventDynamicSqlSupport.ctime, SqlBuilder.isGreaterThanOrEqualTo(beginTime))
                .and(SysLoggerEventDynamicSqlSupport.ctime, SqlBuilder.isLessThanOrEqualTo(endTime))
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<SysLoggerEvent> listLogger(long limit, long offset) {
        return loggerEventMapper.select(c -> c
                .orderBy(SysLoggerEventDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<SysLoggerEvent> listLoggerByUser(String userId, long limit, long offset) {
        return loggerEventMapper.select(c -> c
                .where(SysLoggerEventDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                .orderBy(SysLoggerEventDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<SysLoggerEvent> listLoggerByType(LoggerEventType loggerEventType, long limit, long offset) {
        return loggerEventMapper.select(c -> c
                .where(SysLoggerEventDynamicSqlSupport.eventType, SqlBuilder.isEqualTo(loggerEventType.name()))
                .orderBy(SysLoggerEventDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public List<SysLoggerEvent> listLoggerByTime(String beginTime, String endTime, long limit, long offset) {
        return loggerEventMapper.select(c -> c
                .where(SysLoggerEventDynamicSqlSupport.ctime, SqlBuilder.isGreaterThanOrEqualTo(beginTime))
                .and(SysLoggerEventDynamicSqlSupport.ctime, SqlBuilder.isLessThanOrEqualTo(endTime))
                .orderBy(SysLoggerEventDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @DataSourceConfig.ReadOnly
    @Override
    public SysLoggerEvent getLogger(String id) {
        return loggerEventMapper.selectByPrimaryKey(id).orElse(null);
    }
}
