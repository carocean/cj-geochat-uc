package cj.geochat.uc.middle.mapper;

import static cj.geochat.uc.middle.mapper.PaAppCapabilityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.uc.middle.model.PaAppCapability;
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
public interface PaAppCapabilityMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PaAppCapability>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, appId, abilityId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaAppCapabilityResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="ability_id", property="abilityId", jdbcType=JdbcType.VARCHAR)
    })
    List<PaAppCapability> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaAppCapabilityResult")
    Optional<PaAppCapability> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, paAppCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, paAppCapability, completer);
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
    default int insert(PaAppCapability row) {
        return MyBatis3Utils.insert(this::insert, row, paAppCapability, c ->
            c.map(id).toProperty("id")
            .map(appId).toProperty("appId")
            .map(abilityId).toProperty("abilityId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<PaAppCapability> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, paAppCapability, c ->
            c.map(id).toProperty("id")
            .map(appId).toProperty("appId")
            .map(abilityId).toProperty("abilityId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(PaAppCapability row) {
        return MyBatis3Utils.insert(this::insert, row, paAppCapability, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(appId).toPropertyWhenPresent("appId", row::getAppId)
            .map(abilityId).toPropertyWhenPresent("abilityId", row::getAbilityId)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppCapability> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, paAppCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppCapability> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, paAppCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppCapability> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, paAppCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppCapability> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, paAppCapability, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(PaAppCapability row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(appId).equalTo(row::getAppId)
                .set(abilityId).equalTo(row::getAbilityId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PaAppCapability row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(appId).equalToWhenPresent(row::getAppId)
                .set(abilityId).equalToWhenPresent(row::getAbilityId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(PaAppCapability row) {
        return update(c ->
            c.set(appId).equalTo(row::getAppId)
            .set(abilityId).equalTo(row::getAbilityId)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(PaAppCapability row) {
        return update(c ->
            c.set(appId).equalToWhenPresent(row::getAppId)
            .set(abilityId).equalToWhenPresent(row::getAbilityId)
            .where(id, isEqualTo(row::getId))
        );
    }
}