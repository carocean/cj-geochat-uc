package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.PaAppAuthorityDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.PaAppAuthority;
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
public interface PaAppAuthorityMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<PaAppAuthority>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, roleId, appId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PaAppAuthorityResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.VARCHAR),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.VARCHAR)
    })
    List<PaAppAuthority> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PaAppAuthorityResult")
    Optional<PaAppAuthority> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, paAppAuthority, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, paAppAuthority, completer);
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
    default int insert(PaAppAuthority row) {
        return MyBatis3Utils.insert(this::insert, row, paAppAuthority, c ->
            c.map(id).toProperty("id")
            .map(roleId).toProperty("roleId")
            .map(appId).toProperty("appId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<PaAppAuthority> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, paAppAuthority, c ->
            c.map(id).toProperty("id")
            .map(roleId).toProperty("roleId")
            .map(appId).toProperty("appId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(PaAppAuthority row) {
        return MyBatis3Utils.insert(this::insert, row, paAppAuthority, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(roleId).toPropertyWhenPresent("roleId", row::getRoleId)
            .map(appId).toPropertyWhenPresent("appId", row::getAppId)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppAuthority> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, paAppAuthority, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppAuthority> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, paAppAuthority, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<PaAppAuthority> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, paAppAuthority, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<PaAppAuthority> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, paAppAuthority, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(PaAppAuthority row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(roleId).equalTo(row::getRoleId)
                .set(appId).equalTo(row::getAppId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(PaAppAuthority row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(roleId).equalToWhenPresent(row::getRoleId)
                .set(appId).equalToWhenPresent(row::getAppId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(PaAppAuthority row) {
        return update(c ->
            c.set(roleId).equalTo(row::getRoleId)
            .set(appId).equalTo(row::getAppId)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(PaAppAuthority row) {
        return update(c ->
            c.set(roleId).equalToWhenPresent(row::getRoleId)
            .set(appId).equalToWhenPresent(row::getAppId)
            .where(id, isEqualTo(row::getId))
        );
    }
}