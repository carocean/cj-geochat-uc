package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.UcDeviceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.UcDevice;
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
public interface UcDeviceMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UcDevice>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, identifier, osName, deviceName, deviceVersion);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UcDeviceResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="identifier", property="identifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="os_name", property="osName", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_name", property="deviceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_version", property="deviceVersion", jdbcType=JdbcType.VARCHAR)
    })
    List<UcDevice> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UcDeviceResult")
    Optional<UcDevice> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ucDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ucDevice, completer);
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
    default int insert(UcDevice row) {
        return MyBatis3Utils.insert(this::insert, row, ucDevice, c ->
            c.map(id).toProperty("id")
            .map(identifier).toProperty("identifier")
            .map(osName).toProperty("osName")
            .map(deviceName).toProperty("deviceName")
            .map(deviceVersion).toProperty("deviceVersion")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<UcDevice> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ucDevice, c ->
            c.map(id).toProperty("id")
            .map(identifier).toProperty("identifier")
            .map(osName).toProperty("osName")
            .map(deviceName).toProperty("deviceName")
            .map(deviceVersion).toProperty("deviceVersion")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(UcDevice row) {
        return MyBatis3Utils.insert(this::insert, row, ucDevice, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(identifier).toPropertyWhenPresent("identifier", row::getIdentifier)
            .map(osName).toPropertyWhenPresent("osName", row::getOsName)
            .map(deviceName).toPropertyWhenPresent("deviceName", row::getDeviceName)
            .map(deviceVersion).toPropertyWhenPresent("deviceVersion", row::getDeviceVersion)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcDevice> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ucDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcDevice> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ucDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcDevice> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ucDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcDevice> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ucDevice, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(UcDevice row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(identifier).equalTo(row::getIdentifier)
                .set(osName).equalTo(row::getOsName)
                .set(deviceName).equalTo(row::getDeviceName)
                .set(deviceVersion).equalTo(row::getDeviceVersion);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UcDevice row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(identifier).equalToWhenPresent(row::getIdentifier)
                .set(osName).equalToWhenPresent(row::getOsName)
                .set(deviceName).equalToWhenPresent(row::getDeviceName)
                .set(deviceVersion).equalToWhenPresent(row::getDeviceVersion);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(UcDevice row) {
        return update(c ->
            c.set(identifier).equalTo(row::getIdentifier)
            .set(osName).equalTo(row::getOsName)
            .set(deviceName).equalTo(row::getDeviceName)
            .set(deviceVersion).equalTo(row::getDeviceVersion)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(UcDevice row) {
        return update(c ->
            c.set(identifier).equalToWhenPresent(row::getIdentifier)
            .set(osName).equalToWhenPresent(row::getOsName)
            .set(deviceName).equalToWhenPresent(row::getDeviceName)
            .set(deviceVersion).equalToWhenPresent(row::getDeviceVersion)
            .where(id, isEqualTo(row::getId))
        );
    }
}