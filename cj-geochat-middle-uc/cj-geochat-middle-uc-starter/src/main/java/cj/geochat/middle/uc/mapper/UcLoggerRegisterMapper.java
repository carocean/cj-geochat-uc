package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.UcLoggerRegisterDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.UcLoggerRegister;
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
public interface UcLoggerRegisterMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UcLoggerRegister>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, eventType, eventTitle, userId, accountId, accountCate, sourceType, sourceDesc, message, status, ipAddress, osPlatform, regUsername, regAccount, avatar, city, regLanguage, ctime, year, month, day);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UcLoggerRegisterResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="event_type", property="eventType", jdbcType=JdbcType.TINYINT),
        @Result(column="event_title", property="eventTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_id", property="accountId", jdbcType=JdbcType.VARCHAR),
        @Result(column="account_cate", property="accountCate", jdbcType=JdbcType.BIT),
        @Result(column="source_type", property="sourceType", jdbcType=JdbcType.TINYINT),
        @Result(column="source_desc", property="sourceDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="message", property="message", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip_address", property="ipAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="os_platform", property="osPlatform", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_username", property="regUsername", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_account", property="regAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="reg_language", property="regLanguage", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.VARCHAR),
        @Result(column="year", property="year", jdbcType=JdbcType.INTEGER),
        @Result(column="month", property="month", jdbcType=JdbcType.INTEGER),
        @Result(column="day", property="day", jdbcType=JdbcType.INTEGER)
    })
    List<UcLoggerRegister> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UcLoggerRegisterResult")
    Optional<UcLoggerRegister> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ucLoggerRegister, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ucLoggerRegister, completer);
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
    default int insert(UcLoggerRegister row) {
        return MyBatis3Utils.insert(this::insert, row, ucLoggerRegister, c ->
            c.map(id).toProperty("id")
            .map(eventType).toProperty("eventType")
            .map(eventTitle).toProperty("eventTitle")
            .map(userId).toProperty("userId")
            .map(accountId).toProperty("accountId")
            .map(accountCate).toProperty("accountCate")
            .map(sourceType).toProperty("sourceType")
            .map(sourceDesc).toProperty("sourceDesc")
            .map(message).toProperty("message")
            .map(status).toProperty("status")
            .map(ipAddress).toProperty("ipAddress")
            .map(osPlatform).toProperty("osPlatform")
            .map(regUsername).toProperty("regUsername")
            .map(regAccount).toProperty("regAccount")
            .map(avatar).toProperty("avatar")
            .map(city).toProperty("city")
            .map(regLanguage).toProperty("regLanguage")
            .map(ctime).toProperty("ctime")
            .map(year).toProperty("year")
            .map(month).toProperty("month")
            .map(day).toProperty("day")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<UcLoggerRegister> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ucLoggerRegister, c ->
            c.map(id).toProperty("id")
            .map(eventType).toProperty("eventType")
            .map(eventTitle).toProperty("eventTitle")
            .map(userId).toProperty("userId")
            .map(accountId).toProperty("accountId")
            .map(accountCate).toProperty("accountCate")
            .map(sourceType).toProperty("sourceType")
            .map(sourceDesc).toProperty("sourceDesc")
            .map(message).toProperty("message")
            .map(status).toProperty("status")
            .map(ipAddress).toProperty("ipAddress")
            .map(osPlatform).toProperty("osPlatform")
            .map(regUsername).toProperty("regUsername")
            .map(regAccount).toProperty("regAccount")
            .map(avatar).toProperty("avatar")
            .map(city).toProperty("city")
            .map(regLanguage).toProperty("regLanguage")
            .map(ctime).toProperty("ctime")
            .map(year).toProperty("year")
            .map(month).toProperty("month")
            .map(day).toProperty("day")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(UcLoggerRegister row) {
        return MyBatis3Utils.insert(this::insert, row, ucLoggerRegister, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(eventType).toPropertyWhenPresent("eventType", row::getEventType)
            .map(eventTitle).toPropertyWhenPresent("eventTitle", row::getEventTitle)
            .map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(accountId).toPropertyWhenPresent("accountId", row::getAccountId)
            .map(accountCate).toPropertyWhenPresent("accountCate", row::getAccountCate)
            .map(sourceType).toPropertyWhenPresent("sourceType", row::getSourceType)
            .map(sourceDesc).toPropertyWhenPresent("sourceDesc", row::getSourceDesc)
            .map(message).toPropertyWhenPresent("message", row::getMessage)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(ipAddress).toPropertyWhenPresent("ipAddress", row::getIpAddress)
            .map(osPlatform).toPropertyWhenPresent("osPlatform", row::getOsPlatform)
            .map(regUsername).toPropertyWhenPresent("regUsername", row::getRegUsername)
            .map(regAccount).toPropertyWhenPresent("regAccount", row::getRegAccount)
            .map(avatar).toPropertyWhenPresent("avatar", row::getAvatar)
            .map(city).toPropertyWhenPresent("city", row::getCity)
            .map(regLanguage).toPropertyWhenPresent("regLanguage", row::getRegLanguage)
            .map(ctime).toPropertyWhenPresent("ctime", row::getCtime)
            .map(year).toPropertyWhenPresent("year", row::getYear)
            .map(month).toPropertyWhenPresent("month", row::getMonth)
            .map(day).toPropertyWhenPresent("day", row::getDay)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcLoggerRegister> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ucLoggerRegister, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcLoggerRegister> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ucLoggerRegister, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcLoggerRegister> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ucLoggerRegister, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcLoggerRegister> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ucLoggerRegister, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(UcLoggerRegister row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(eventType).equalTo(row::getEventType)
                .set(eventTitle).equalTo(row::getEventTitle)
                .set(userId).equalTo(row::getUserId)
                .set(accountId).equalTo(row::getAccountId)
                .set(accountCate).equalTo(row::getAccountCate)
                .set(sourceType).equalTo(row::getSourceType)
                .set(sourceDesc).equalTo(row::getSourceDesc)
                .set(message).equalTo(row::getMessage)
                .set(status).equalTo(row::getStatus)
                .set(ipAddress).equalTo(row::getIpAddress)
                .set(osPlatform).equalTo(row::getOsPlatform)
                .set(regUsername).equalTo(row::getRegUsername)
                .set(regAccount).equalTo(row::getRegAccount)
                .set(avatar).equalTo(row::getAvatar)
                .set(city).equalTo(row::getCity)
                .set(regLanguage).equalTo(row::getRegLanguage)
                .set(ctime).equalTo(row::getCtime)
                .set(year).equalTo(row::getYear)
                .set(month).equalTo(row::getMonth)
                .set(day).equalTo(row::getDay);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UcLoggerRegister row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(eventType).equalToWhenPresent(row::getEventType)
                .set(eventTitle).equalToWhenPresent(row::getEventTitle)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(accountId).equalToWhenPresent(row::getAccountId)
                .set(accountCate).equalToWhenPresent(row::getAccountCate)
                .set(sourceType).equalToWhenPresent(row::getSourceType)
                .set(sourceDesc).equalToWhenPresent(row::getSourceDesc)
                .set(message).equalToWhenPresent(row::getMessage)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(ipAddress).equalToWhenPresent(row::getIpAddress)
                .set(osPlatform).equalToWhenPresent(row::getOsPlatform)
                .set(regUsername).equalToWhenPresent(row::getRegUsername)
                .set(regAccount).equalToWhenPresent(row::getRegAccount)
                .set(avatar).equalToWhenPresent(row::getAvatar)
                .set(city).equalToWhenPresent(row::getCity)
                .set(regLanguage).equalToWhenPresent(row::getRegLanguage)
                .set(ctime).equalToWhenPresent(row::getCtime)
                .set(year).equalToWhenPresent(row::getYear)
                .set(month).equalToWhenPresent(row::getMonth)
                .set(day).equalToWhenPresent(row::getDay);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(UcLoggerRegister row) {
        return update(c ->
            c.set(eventType).equalTo(row::getEventType)
            .set(eventTitle).equalTo(row::getEventTitle)
            .set(userId).equalTo(row::getUserId)
            .set(accountId).equalTo(row::getAccountId)
            .set(accountCate).equalTo(row::getAccountCate)
            .set(sourceType).equalTo(row::getSourceType)
            .set(sourceDesc).equalTo(row::getSourceDesc)
            .set(message).equalTo(row::getMessage)
            .set(status).equalTo(row::getStatus)
            .set(ipAddress).equalTo(row::getIpAddress)
            .set(osPlatform).equalTo(row::getOsPlatform)
            .set(regUsername).equalTo(row::getRegUsername)
            .set(regAccount).equalTo(row::getRegAccount)
            .set(avatar).equalTo(row::getAvatar)
            .set(city).equalTo(row::getCity)
            .set(regLanguage).equalTo(row::getRegLanguage)
            .set(ctime).equalTo(row::getCtime)
            .set(year).equalTo(row::getYear)
            .set(month).equalTo(row::getMonth)
            .set(day).equalTo(row::getDay)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(UcLoggerRegister row) {
        return update(c ->
            c.set(eventType).equalToWhenPresent(row::getEventType)
            .set(eventTitle).equalToWhenPresent(row::getEventTitle)
            .set(userId).equalToWhenPresent(row::getUserId)
            .set(accountId).equalToWhenPresent(row::getAccountId)
            .set(accountCate).equalToWhenPresent(row::getAccountCate)
            .set(sourceType).equalToWhenPresent(row::getSourceType)
            .set(sourceDesc).equalToWhenPresent(row::getSourceDesc)
            .set(message).equalToWhenPresent(row::getMessage)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(ipAddress).equalToWhenPresent(row::getIpAddress)
            .set(osPlatform).equalToWhenPresent(row::getOsPlatform)
            .set(regUsername).equalToWhenPresent(row::getRegUsername)
            .set(regAccount).equalToWhenPresent(row::getRegAccount)
            .set(avatar).equalToWhenPresent(row::getAvatar)
            .set(city).equalToWhenPresent(row::getCity)
            .set(regLanguage).equalToWhenPresent(row::getRegLanguage)
            .set(ctime).equalToWhenPresent(row::getCtime)
            .set(year).equalToWhenPresent(row::getYear)
            .set(month).equalToWhenPresent(row::getMonth)
            .set(day).equalToWhenPresent(row::getDay)
            .where(id, isEqualTo(row::getId))
        );
    }
}