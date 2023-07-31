package cj.geochat.uc.middle.mapper;

import static cj.geochat.uc.middle.mapper.UcUserDeviceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.uc.middle.model.UcUserDevice;
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
public interface UcUserDeviceMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UcUserDevice>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, identifier, osName, deviceName, deviceVersion);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UcUserDeviceResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="identifier", property="identifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="os_name", property="osName", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_name", property="deviceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_version", property="deviceVersion", jdbcType=JdbcType.VARCHAR)
    })
    List<UcUserDevice> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UcUserDeviceResult")
    Optional<UcUserDevice> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ucUserDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ucUserDevice, completer);
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
    default int insert(UcUserDevice row) {
        return MyBatis3Utils.insert(this::insert, row, ucUserDevice, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(identifier).toProperty("identifier")
            .map(osName).toProperty("osName")
            .map(deviceName).toProperty("deviceName")
            .map(deviceVersion).toProperty("deviceVersion")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<UcUserDevice> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ucUserDevice, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(identifier).toProperty("identifier")
            .map(osName).toProperty("osName")
            .map(deviceName).toProperty("deviceName")
            .map(deviceVersion).toProperty("deviceVersion")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(UcUserDevice row) {
        return MyBatis3Utils.insert(this::insert, row, ucUserDevice, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(identifier).toPropertyWhenPresent("identifier", row::getIdentifier)
            .map(osName).toPropertyWhenPresent("osName", row::getOsName)
            .map(deviceName).toPropertyWhenPresent("deviceName", row::getDeviceName)
            .map(deviceVersion).toPropertyWhenPresent("deviceVersion", row::getDeviceVersion)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcUserDevice> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ucUserDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcUserDevice> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ucUserDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcUserDevice> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ucUserDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcUserDevice> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ucUserDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(UcUserDevice row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(userId).equalTo(row::getUserId)
                .set(identifier).equalTo(row::getIdentifier)
                .set(osName).equalTo(row::getOsName)
                .set(deviceName).equalTo(row::getDeviceName)
                .set(deviceVersion).equalTo(row::getDeviceVersion);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UcUserDevice row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(identifier).equalToWhenPresent(row::getIdentifier)
                .set(osName).equalToWhenPresent(row::getOsName)
                .set(deviceName).equalToWhenPresent(row::getDeviceName)
                .set(deviceVersion).equalToWhenPresent(row::getDeviceVersion);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(UcUserDevice row) {
        return update(c ->
            c.set(userId).equalTo(row::getUserId)
            .set(identifier).equalTo(row::getIdentifier)
            .set(osName).equalTo(row::getOsName)
            .set(deviceName).equalTo(row::getDeviceName)
            .set(deviceVersion).equalTo(row::getDeviceVersion)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(UcUserDevice row) {
        return update(c ->
            c.set(userId).equalToWhenPresent(row::getUserId)
            .set(identifier).equalToWhenPresent(row::getIdentifier)
            .set(osName).equalToWhenPresent(row::getOsName)
            .set(deviceName).equalToWhenPresent(row::getDeviceName)
            .set(deviceVersion).equalToWhenPresent(row::getDeviceVersion)
            .where(id, isEqualTo(row::getId))
        );
    }
}