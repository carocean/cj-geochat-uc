package cj.geochat.uc.middle.mapper;

import static cj.geochat.uc.middle.mapper.PaAppResourceIdDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.uc.middle.model.PaAppResourceId;
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
public interface PaAppResourceIdMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PaAppResourceId>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, resourceId, appId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaAppResourceIdResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="resource_id", property="resourceId", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR)
    })
    List<PaAppResourceId> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaAppResourceIdResult")
    Optional<PaAppResourceId> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, paAppResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, paAppResourceId, completer);
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
    default int insert(PaAppResourceId row) {
        return MyBatis3Utils.insert(this::insert, row, paAppResourceId, c ->
            c.map(id).toProperty("id")
            .map(resourceId).toProperty("resourceId")
            .map(appId).toProperty("appId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<PaAppResourceId> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, paAppResourceId, c ->
            c.map(id).toProperty("id")
            .map(resourceId).toProperty("resourceId")
            .map(appId).toProperty("appId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(PaAppResourceId row) {
        return MyBatis3Utils.insert(this::insert, row, paAppResourceId, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(resourceId).toPropertyWhenPresent("resourceId", row::getResourceId)
            .map(appId).toPropertyWhenPresent("appId", row::getAppId)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppResourceId> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, paAppResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppResourceId> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, paAppResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppResourceId> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, paAppResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppResourceId> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, paAppResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(PaAppResourceId row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(resourceId).equalTo(row::getResourceId)
                .set(appId).equalTo(row::getAppId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PaAppResourceId row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(resourceId).equalToWhenPresent(row::getResourceId)
                .set(appId).equalToWhenPresent(row::getAppId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(PaAppResourceId row) {
        return update(c ->
            c.set(resourceId).equalTo(row::getResourceId)
            .set(appId).equalTo(row::getAppId)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(PaAppResourceId row) {
        return update(c ->
            c.set(resourceId).equalToWhenPresent(row::getResourceId)
            .set(appId).equalToWhenPresent(row::getAppId)
            .where(id, isEqualTo(row::getId))
        );
    }
}