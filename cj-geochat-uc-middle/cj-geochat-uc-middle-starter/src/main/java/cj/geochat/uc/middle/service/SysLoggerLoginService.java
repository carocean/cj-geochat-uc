package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.uc.middle.LoggerEventType;
import cj.geochat.uc.middle.mapper.SysLoggerLoginDynamicSqlSupport;
import cj.geochat.uc.middle.mapper.SysLoggerLoginMapper;
import cj.geochat.uc.middle.model.SysLoggerLogin;
import com.github.f4b6a3.ulid.UlidCreator;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class SysLoggerLoginService implements ISysLoggerLoginService {
    @Autowired
    SysLoggerLoginMapper loggerLoginMapper;

    @Transactional
    @Override
    public void logger(SysLoggerLogin loggerLogin) {
        if (!StringUtils.hasText(loggerLogin.getId())) {
            loggerLogin.setId(UlidCreator.getUlid().toLowerCase());
        }
        loggerLoginMapper.insertSelective(loggerLogin);
    }

    @Transactional
    @Override
    public void remove(String beginTime, String endTime) {
        loggerLoginMapper.delete(c -> c
                .where(SysLoggerLoginDynamicSqlSupport.ctime, SqlBuilder.isGreaterThanOrEqualTo(beginTime))
                .and(SysLoggerLoginDynamicSqlSupport.ctime, SqlBuilder.isLessThanOrEqualTo(endTime))
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<SysLoggerLogin> listLogger(long limit, long offset) {
        return loggerLoginMapper.select(c -> c
                .orderBy(SysLoggerLoginDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<SysLoggerLogin> listLoggerByUser(String userId, long limit, long offset) {
        return loggerLoginMapper.select(c -> c
                .where(SysLoggerLoginDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                .orderBy(SysLoggerLoginDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<SysLoggerLogin> listLoggerByType(LoggerEventType eventType, long limit, long offset) {
        return loggerLoginMapper.select(c -> c
                .where(SysLoggerLoginDynamicSqlSupport.eventType, SqlBuilder.isEqualTo(eventType.name()))
                .orderBy(SysLoggerLoginDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<SysLoggerLogin> listLoggerByTime(String beginTime, String endTime, long limit, long offset) {
        return loggerLoginMapper.select(c -> c
                .where(SysLoggerLoginDynamicSqlSupport.ctime, SqlBuilder.isGreaterThanOrEqualTo(beginTime))
                .and(SysLoggerLoginDynamicSqlSupport.ctime, SqlBuilder.isLessThanOrEqualTo(endTime))
                .orderBy(SysLoggerLoginDynamicSqlSupport.ctime.descending())
                .limit(limit)
                .offset(offset)
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public SysLoggerLogin getLogger(String id) {
        return loggerLoginMapper.selectByPrimaryKey(id).orElse(null);
    }
}
