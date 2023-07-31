package cj.geochat.uc.middle.mapper;

import static cj.geochat.uc.middle.mapper.SysLoggerEventDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.uc.middle.model.SysLoggerEvent;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import org.springframework.stereotype.Repository;

@Repository
public interface SysLoggerEventMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<SysLoggerEvent>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, eventType, eventTitle, eventContent, userId, accountId, message, status, ctime);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysLoggerEventResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="event_type", property="eventType", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_title", property="eventTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="event_content", property="eventContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.VARCHAR)
    })
    List<SysLoggerEvent> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysLoggerEventResult")
    Optional<SysLoggerEvent> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysLoggerEvent, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysLoggerEvent, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int deleteByPrimaryKey(String id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insert(SysLoggerEvent row) {
        return MyBatis3Utils.insert(this::insert, row, sysLoggerEvent, c ->
            c.map(id).toProperty("id")
            .map(eventType).toProperty("eventType")
            .map(eventTitle).toProperty("eventTitle")
            .map(eventContent).toProperty("eventContent")
            .map(userId).toProperty("userId")
            .map(accountId).toProperty("accountId")
            .map(message).toProperty("message")
            .map(status).toProperty("status")
            .map(ctime).toProperty("ctime")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<SysLoggerEvent> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, sysLoggerEvent, c ->
            c.map(id).toProperty("id")
            .map(eventType).toProperty("eventType")
            .map(eventTitle).toProperty("eventTitle")
            .map(eventContent).toProperty("eventContent")
            .map(userId).toProperty("userId")
            .map(accountId).toProperty("accountId")
            .map(message).toProperty("message")
            .map(status).toProperty("status")
            .map(ctime).toProperty("ctime")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(SysLoggerEvent row) {
        return MyBatis3Utils.insert(this::insert, row, sysLoggerEvent, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(eventType).toPropertyWhenPresent("eventType", row::getEventType)
            .map(eventTitle).toPropertyWhenPresent("eventTitle", row::getEventTitle)
            .map(eventContent).toPropertyWhenPresent("eventContent", row::getEventContent)
            .map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(accountId).toPropertyWhenPresent("accountId", row::getAccountId)
            .map(message).toPropertyWhenPresent("message", row::getMessage)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(ctime).toPropertyWhenPresent("ctime", row::getCtime)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<SysLoggerEvent> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysLoggerEvent, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<SysLoggerEvent> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysLoggerEvent, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<SysLoggerEvent> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysLoggerEvent, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<SysLoggerEvent> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysLoggerEvent, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(SysLoggerEvent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(eventType).equalTo(row::getEventType)
                .set(eventTitle).equalTo(row::getEventTitle)
                .set(eventContent).equalTo(row::getEventContent)
                .set(userId).equalTo(row::getUserId)
                .set(accountId).equalTo(row::getAccountId)
                .set(message).equalTo(row::getMessage)
                .set(status).equalTo(row::getStatus)
                .set(ctime).equalTo(row::getCtime);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysLoggerEvent row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(eventType).equalToWhenPresent(row::getEventType)
                .set(eventTitle).equalToWhenPresent(row::getEventTitle)
                .set(eventContent).equalToWhenPresent(row::getEventContent)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(accountId).equalToWhenPresent(row::getAccountId)
                .set(message).equalToWhenPresent(row::getMessage)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(ctime).equalToWhenPresent(row::getCtime);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(SysLoggerEvent row) {
        return update(c ->
            c.set(eventType).equalTo(row::getEventType)
            .set(eventTitle).equalTo(row::getEventTitle)
            .set(eventContent).equalTo(row::getEventContent)
            .set(userId).equalTo(row::getUserId)
            .set(accountId).equalTo(row::getAccountId)
            .set(message).equalTo(row::getMessage)
            .set(status).equalTo(row::getStatus)
            .set(ctime).equalTo(row::getCtime)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(SysLoggerEvent row) {
        return update(c ->
            c.set(eventType).equalToWhenPresent(row::getEventType)
            .set(eventTitle).equalToWhenPresent(row::getEventTitle)
            .set(eventContent).equalToWhenPresent(row::getEventContent)
            .set(userId).equalToWhenPresent(row::getUserId)
            .set(accountId).equalToWhenPresent(row::getAccountId)
            .set(message).equalToWhenPresent(row::getMessage)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(ctime).equalToWhenPresent(row::getCtime)
            .where(id, isEqualTo(row::getId))
        );
    }
}