package cj.geochat.uc.middle.mapper;

import static cj.geochat.uc.middle.mapper.PaAppGrantTypeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.uc.middle.model.PaAppGrantType;
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
public interface PaAppGrantTypeMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PaAppGrantType>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, appId, grantType);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaAppGrantTypeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="grant_type", property="grantType", jdbcType=JdbcType.VARCHAR)
    })
    List<PaAppGrantType> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaAppGrantTypeResult")
    Optional<PaAppGrantType> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, paAppGrantType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, paAppGrantType, completer);
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
    default int insert(PaAppGrantType row) {
        return MyBatis3Utils.insert(this::insert, row, paAppGrantType, c ->
            c.map(id).toProperty("id")
            .map(appId).toProperty("appId")
            .map(grantType).toProperty("grantType")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<PaAppGrantType> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, paAppGrantType, c ->
            c.map(id).toProperty("id")
            .map(appId).toProperty("appId")
            .map(grantType).toProperty("grantType")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(PaAppGrantType row) {
        return MyBatis3Utils.insert(this::insert, row, paAppGrantType, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(appId).toPropertyWhenPresent("appId", row::getAppId)
            .map(grantType).toPropertyWhenPresent("grantType", row::getGrantType)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppGrantType> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, paAppGrantType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppGrantType> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, paAppGrantType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppGrantType> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, paAppGrantType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppGrantType> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, paAppGrantType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(PaAppGrantType row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(appId).equalTo(row::getAppId)
                .set(grantType).equalTo(row::getGrantType);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PaAppGrantType row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(appId).equalToWhenPresent(row::getAppId)
                .set(grantType).equalToWhenPresent(row::getGrantType);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(PaAppGrantType row) {
        return update(c ->
            c.set(appId).equalTo(row::getAppId)
            .set(grantType).equalTo(row::getGrantType)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(PaAppGrantType row) {
        return update(c ->
            c.set(appId).equalToWhenPresent(row::getAppId)
            .set(grantType).equalToWhenPresent(row::getGrantType)
            .where(id, isEqualTo(row::getId))
        );
    }
}