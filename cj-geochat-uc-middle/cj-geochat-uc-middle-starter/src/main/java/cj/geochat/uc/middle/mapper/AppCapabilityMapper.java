package cj.geochat.uc.middle.mapper;

import static cj.geochat.uc.middle.mapper.AppCapabilityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.uc.middle.model.AppCapability;
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
public interface AppCapabilityMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<AppCapability>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, abilityCode, abilityName, abilityDesc, order);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AppCapabilityResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="ability_code", property="abilityCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="ability_name", property="abilityName", jdbcType=JdbcType.VARCHAR),
        @Result(column="ability_desc", property="abilityDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="order", property="order", jdbcType=JdbcType.INTEGER)
    })
    List<AppCapability> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AppCapabilityResult")
    Optional<AppCapability> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, appCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, appCapability, completer);
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
    default int insert(AppCapability row) {
        return MyBatis3Utils.insert(this::insert, row, appCapability, c ->
            c.map(id).toProperty("id")
            .map(abilityCode).toProperty("abilityCode")
            .map(abilityName).toProperty("abilityName")
            .map(abilityDesc).toProperty("abilityDesc")
            .map(order).toProperty("order")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<AppCapability> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, appCapability, c ->
            c.map(id).toProperty("id")
            .map(abilityCode).toProperty("abilityCode")
            .map(abilityName).toProperty("abilityName")
            .map(abilityDesc).toProperty("abilityDesc")
            .map(order).toProperty("order")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(AppCapability row) {
        return MyBatis3Utils.insert(this::insert, row, appCapability, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(abilityCode).toPropertyWhenPresent("abilityCode", row::getAbilityCode)
            .map(abilityName).toPropertyWhenPresent("abilityName", row::getAbilityName)
            .map(abilityDesc).toPropertyWhenPresent("abilityDesc", row::getAbilityDesc)
            .map(order).toPropertyWhenPresent("order", row::getOrder)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<AppCapability> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, appCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<AppCapability> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, appCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<AppCapability> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, appCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<AppCapability> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, appCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(AppCapability row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(abilityCode).equalTo(row::getAbilityCode)
                .set(abilityName).equalTo(row::getAbilityName)
                .set(abilityDesc).equalTo(row::getAbilityDesc)
                .set(order).equalTo(row::getOrder);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AppCapability row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(abilityCode).equalToWhenPresent(row::getAbilityCode)
                .set(abilityName).equalToWhenPresent(row::getAbilityName)
                .set(abilityDesc).equalToWhenPresent(row::getAbilityDesc)
                .set(order).equalToWhenPresent(row::getOrder);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(AppCapability row) {
        return update(c ->
            c.set(abilityCode).equalTo(row::getAbilityCode)
            .set(abilityName).equalTo(row::getAbilityName)
            .set(abilityDesc).equalTo(row::getAbilityDesc)
            .set(order).equalTo(row::getOrder)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(AppCapability row) {
        return update(c ->
            c.set(abilityCode).equalToWhenPresent(row::getAbilityCode)
            .set(abilityName).equalToWhenPresent(row::getAbilityName)
            .set(abilityDesc).equalToWhenPresent(row::getAbilityDesc)
            .set(order).equalToWhenPresent(row::getOrder)
            .where(id, isEqualTo(row::getId))
        );
    }
}