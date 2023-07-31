package cj.geochat.uc.middle.mapper;

import static cj.geochat.uc.middle.mapper.ApplicationDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.uc.middle.model.Application;
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
public interface ApplicationMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<Application>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, appKey, appKeyIssuedAt, appSecret, appSecretIssuedAt, appName, typeId, cateId, autoapprove, refreshTokenValidity, authCodeValidity, accessTokenValidity, reuseRefreshTokens);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="ApplicationResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="app_key", property="appKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_key_issued_at", property="appKeyIssuedAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_secret", property="appSecret", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_secret_issued_at", property="appSecretIssuedAt", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_name", property="appName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_id", property="typeId", jdbcType=JdbcType.VARCHAR),
        @Result(column="cate_id", property="cateId", jdbcType=JdbcType.VARCHAR),
        @Result(column="autoapprove", property="autoapprove", jdbcType=JdbcType.BIT),
        @Result(column="refresh_token_validity", property="refreshTokenValidity", jdbcType=JdbcType.BIGINT),
        @Result(column="auth_code_validity", property="authCodeValidity", jdbcType=JdbcType.BIGINT),
        @Result(column="access_token_validity", property="accessTokenValidity", jdbcType=JdbcType.BIGINT),
        @Result(column="reuse_refresh_tokens", property="reuseRefreshTokens", jdbcType=JdbcType.BIT)
    })
    List<Application> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("ApplicationResult")
    Optional<Application> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, application, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, application, completer);
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
    default int insert(Application row) {
        return MyBatis3Utils.insert(this::insert, row, application, c ->
            c.map(id).toProperty("id")
            .map(appKey).toProperty("appKey")
            .map(appKeyIssuedAt).toProperty("appKeyIssuedAt")
            .map(appSecret).toProperty("appSecret")
            .map(appSecretIssuedAt).toProperty("appSecretIssuedAt")
            .map(appName).toProperty("appName")
            .map(typeId).toProperty("typeId")
            .map(cateId).toProperty("cateId")
            .map(autoapprove).toProperty("autoapprove")
            .map(refreshTokenValidity).toProperty("refreshTokenValidity")
            .map(authCodeValidity).toProperty("authCodeValidity")
            .map(accessTokenValidity).toProperty("accessTokenValidity")
            .map(reuseRefreshTokens).toProperty("reuseRefreshTokens")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<Application> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, application, c ->
            c.map(id).toProperty("id")
            .map(appKey).toProperty("appKey")
            .map(appKeyIssuedAt).toProperty("appKeyIssuedAt")
            .map(appSecret).toProperty("appSecret")
            .map(appSecretIssuedAt).toProperty("appSecretIssuedAt")
            .map(appName).toProperty("appName")
            .map(typeId).toProperty("typeId")
            .map(cateId).toProperty("cateId")
            .map(autoapprove).toProperty("autoapprove")
            .map(refreshTokenValidity).toProperty("refreshTokenValidity")
            .map(authCodeValidity).toProperty("authCodeValidity")
            .map(accessTokenValidity).toProperty("accessTokenValidity")
            .map(reuseRefreshTokens).toProperty("reuseRefreshTokens")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(Application row) {
        return MyBatis3Utils.insert(this::insert, row, application, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(appKey).toPropertyWhenPresent("appKey", row::getAppKey)
            .map(appKeyIssuedAt).toPropertyWhenPresent("appKeyIssuedAt", row::getAppKeyIssuedAt)
            .map(appSecret).toPropertyWhenPresent("appSecret", row::getAppSecret)
            .map(appSecretIssuedAt).toPropertyWhenPresent("appSecretIssuedAt", row::getAppSecretIssuedAt)
            .map(appName).toPropertyWhenPresent("appName", row::getAppName)
            .map(typeId).toPropertyWhenPresent("typeId", row::getTypeId)
            .map(cateId).toPropertyWhenPresent("cateId", row::getCateId)
            .map(autoapprove).toPropertyWhenPresent("autoapprove", row::getAutoapprove)
            .map(refreshTokenValidity).toPropertyWhenPresent("refreshTokenValidity", row::getRefreshTokenValidity)
            .map(authCodeValidity).toPropertyWhenPresent("authCodeValidity", row::getAuthCodeValidity)
            .map(accessTokenValidity).toPropertyWhenPresent("accessTokenValidity", row::getAccessTokenValidity)
            .map(reuseRefreshTokens).toPropertyWhenPresent("reuseRefreshTokens", row::getReuseRefreshTokens)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Application> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, application, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Application> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, application, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<Application> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, application, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<Application> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, application, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(Application row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(appKey).equalTo(row::getAppKey)
                .set(appKeyIssuedAt).equalTo(row::getAppKeyIssuedAt)
                .set(appSecret).equalTo(row::getAppSecret)
                .set(appSecretIssuedAt).equalTo(row::getAppSecretIssuedAt)
                .set(appName).equalTo(row::getAppName)
                .set(typeId).equalTo(row::getTypeId)
                .set(cateId).equalTo(row::getCateId)
                .set(autoapprove).equalTo(row::getAutoapprove)
                .set(refreshTokenValidity).equalTo(row::getRefreshTokenValidity)
                .set(authCodeValidity).equalTo(row::getAuthCodeValidity)
                .set(accessTokenValidity).equalTo(row::getAccessTokenValidity)
                .set(reuseRefreshTokens).equalTo(row::getReuseRefreshTokens);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(Application row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(appKey).equalToWhenPresent(row::getAppKey)
                .set(appKeyIssuedAt).equalToWhenPresent(row::getAppKeyIssuedAt)
                .set(appSecret).equalToWhenPresent(row::getAppSecret)
                .set(appSecretIssuedAt).equalToWhenPresent(row::getAppSecretIssuedAt)
                .set(appName).equalToWhenPresent(row::getAppName)
                .set(typeId).equalToWhenPresent(row::getTypeId)
                .set(cateId).equalToWhenPresent(row::getCateId)
                .set(autoapprove).equalToWhenPresent(row::getAutoapprove)
                .set(refreshTokenValidity).equalToWhenPresent(row::getRefreshTokenValidity)
                .set(authCodeValidity).equalToWhenPresent(row::getAuthCodeValidity)
                .set(accessTokenValidity).equalToWhenPresent(row::getAccessTokenValidity)
                .set(reuseRefreshTokens).equalToWhenPresent(row::getReuseRefreshTokens);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(Application row) {
        return update(c ->
            c.set(appKey).equalTo(row::getAppKey)
            .set(appKeyIssuedAt).equalTo(row::getAppKeyIssuedAt)
            .set(appSecret).equalTo(row::getAppSecret)
            .set(appSecretIssuedAt).equalTo(row::getAppSecretIssuedAt)
            .set(appName).equalTo(row::getAppName)
            .set(typeId).equalTo(row::getTypeId)
            .set(cateId).equalTo(row::getCateId)
            .set(autoapprove).equalTo(row::getAutoapprove)
            .set(refreshTokenValidity).equalTo(row::getRefreshTokenValidity)
            .set(authCodeValidity).equalTo(row::getAuthCodeValidity)
            .set(accessTokenValidity).equalTo(row::getAccessTokenValidity)
            .set(reuseRefreshTokens).equalTo(row::getReuseRefreshTokens)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(Application row) {
        return update(c ->
            c.set(appKey).equalToWhenPresent(row::getAppKey)
            .set(appKeyIssuedAt).equalToWhenPresent(row::getAppKeyIssuedAt)
            .set(appSecret).equalToWhenPresent(row::getAppSecret)
            .set(appSecretIssuedAt).equalToWhenPresent(row::getAppSecretIssuedAt)
            .set(appName).equalToWhenPresent(row::getAppName)
            .set(typeId).equalToWhenPresent(row::getTypeId)
            .set(cateId).equalToWhenPresent(row::getCateId)
            .set(autoapprove).equalToWhenPresent(row::getAutoapprove)
            .set(refreshTokenValidity).equalToWhenPresent(row::getRefreshTokenValidity)
            .set(authCodeValidity).equalToWhenPresent(row::getAuthCodeValidity)
            .set(accessTokenValidity).equalToWhenPresent(row::getAccessTokenValidity)
            .set(reuseRefreshTokens).equalToWhenPresent(row::getReuseRefreshTokens)
            .where(id, isEqualTo(row::getId))
        );
    }
}