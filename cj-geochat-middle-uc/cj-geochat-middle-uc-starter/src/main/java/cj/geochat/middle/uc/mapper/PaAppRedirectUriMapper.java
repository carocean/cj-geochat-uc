package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.PaAppRedirectUriDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.PaAppRedirectUri;
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
public interface PaAppRedirectUriMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PaAppRedirectUri>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, appId, redirectUri);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaAppRedirectUriResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR),
        @Result(column="redirect_uri", property="redirectUri", jdbcType=JdbcType.VARCHAR)
    })
    List<PaAppRedirectUri> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaAppRedirectUriResult")
    Optional<PaAppRedirectUri> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, paAppRedirectUri, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, paAppRedirectUri, completer);
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
    default int insert(PaAppRedirectUri row) {
        return MyBatis3Utils.insert(this::insert, row, paAppRedirectUri, c ->
            c.map(id).toProperty("id")
            .map(appId).toProperty("appId")
            .map(redirectUri).toProperty("redirectUri")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<PaAppRedirectUri> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, paAppRedirectUri, c ->
            c.map(id).toProperty("id")
            .map(appId).toProperty("appId")
            .map(redirectUri).toProperty("redirectUri")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(PaAppRedirectUri row) {
        return MyBatis3Utils.insert(this::insert, row, paAppRedirectUri, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(appId).toPropertyWhenPresent("appId", row::getAppId)
            .map(redirectUri).toPropertyWhenPresent("redirectUri", row::getRedirectUri)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppRedirectUri> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, paAppRedirectUri, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppRedirectUri> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, paAppRedirectUri, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppRedirectUri> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, paAppRedirectUri, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppRedirectUri> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, paAppRedirectUri, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(PaAppRedirectUri row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(appId).equalTo(row::getAppId)
                .set(redirectUri).equalTo(row::getRedirectUri);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PaAppRedirectUri row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(appId).equalToWhenPresent(row::getAppId)
                .set(redirectUri).equalToWhenPresent(row::getRedirectUri);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(PaAppRedirectUri row) {
        return update(c ->
            c.set(appId).equalTo(row::getAppId)
            .set(redirectUri).equalTo(row::getRedirectUri)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(PaAppRedirectUri row) {
        return update(c ->
            c.set(appId).equalToWhenPresent(row::getAppId)
            .set(redirectUri).equalToWhenPresent(row::getRedirectUri)
            .where(id, isEqualTo(row::getId))
        );
    }
}