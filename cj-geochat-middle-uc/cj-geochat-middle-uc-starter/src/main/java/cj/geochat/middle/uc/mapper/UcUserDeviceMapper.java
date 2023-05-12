package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.UcUserDeviceDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.UcUserDevice;
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
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, deviceId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UcUserDeviceResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="device_id", property="deviceId", jdbcType=JdbcType.VARCHAR)
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
            .map(deviceId).toProperty("deviceId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<UcUserDevice> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ucUserDevice, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(deviceId).toProperty("deviceId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(UcUserDevice row) {
        return MyBatis3Utils.insert(this::insert, row, ucUserDevice, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(deviceId).toPropertyWhenPresent("deviceId", row::getDeviceId)
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
                .set(deviceId).equalTo(row::getDeviceId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UcUserDevice row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(deviceId).equalToWhenPresent(row::getDeviceId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(UcUserDevice row) {
        return update(c ->
            c.set(userId).equalTo(row::getUserId)
            .set(deviceId).equalTo(row::getDeviceId)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(UcUserDevice row) {
        return update(c ->
            c.set(userId).equalToWhenPresent(row::getUserId)
            .set(deviceId).equalToWhenPresent(row::getDeviceId)
            .where(id, isEqualTo(row::getId))
        );
    }
}