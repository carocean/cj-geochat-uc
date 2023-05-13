package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.AppResourceIdDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.AppResourceId;
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
public interface AppResourceIdMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<AppResourceId>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, resourceCode, resourceTitle, resourceDesc);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AppResourceIdResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="resource_code", property="resourceCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_title", property="resourceTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="resource_desc", property="resourceDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<AppResourceId> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AppResourceIdResult")
    Optional<AppResourceId> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, appResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, appResourceId, completer);
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
    default int insert(AppResourceId row) {
        return MyBatis3Utils.insert(this::insert, row, appResourceId, c ->
            c.map(id).toProperty("id")
            .map(resourceCode).toProperty("resourceCode")
            .map(resourceTitle).toProperty("resourceTitle")
            .map(resourceDesc).toProperty("resourceDesc")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<AppResourceId> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, appResourceId, c ->
            c.map(id).toProperty("id")
            .map(resourceCode).toProperty("resourceCode")
            .map(resourceTitle).toProperty("resourceTitle")
            .map(resourceDesc).toProperty("resourceDesc")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(AppResourceId row) {
        return MyBatis3Utils.insert(this::insert, row, appResourceId, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(resourceCode).toPropertyWhenPresent("resourceCode", row::getResourceCode)
            .map(resourceTitle).toPropertyWhenPresent("resourceTitle", row::getResourceTitle)
            .map(resourceDesc).toPropertyWhenPresent("resourceDesc", row::getResourceDesc)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<AppResourceId> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, appResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<AppResourceId> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, appResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<AppResourceId> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, appResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<AppResourceId> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, appResourceId, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(AppResourceId row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(resourceCode).equalTo(row::getResourceCode)
                .set(resourceTitle).equalTo(row::getResourceTitle)
                .set(resourceDesc).equalTo(row::getResourceDesc);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AppResourceId row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(resourceCode).equalToWhenPresent(row::getResourceCode)
                .set(resourceTitle).equalToWhenPresent(row::getResourceTitle)
                .set(resourceDesc).equalToWhenPresent(row::getResourceDesc);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(AppResourceId row) {
        return update(c ->
            c.set(resourceCode).equalTo(row::getResourceCode)
            .set(resourceTitle).equalTo(row::getResourceTitle)
            .set(resourceDesc).equalTo(row::getResourceDesc)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(AppResourceId row) {
        return update(c ->
            c.set(resourceCode).equalToWhenPresent(row::getResourceCode)
            .set(resourceTitle).equalToWhenPresent(row::getResourceTitle)
            .set(resourceDesc).equalToWhenPresent(row::getResourceDesc)
            .where(id, isEqualTo(row::getId))
        );
    }
}