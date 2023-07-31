package cj.geochat.uc.middle.mapper;

import static cj.geochat.uc.middle.mapper.UcRoleDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.uc.middle.model.UcRole;
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
public interface UcRoleMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UcRole>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, roleCode, roleName, note, order);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UcRoleResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="role_code", property="roleCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="order", property="order", jdbcType=JdbcType.INTEGER)
    })
    List<UcRole> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UcRoleResult")
    Optional<UcRole> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ucRole, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ucRole, completer);
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
    default int insert(UcRole row) {
        return MyBatis3Utils.insert(this::insert, row, ucRole, c ->
            c.map(id).toProperty("id")
            .map(roleCode).toProperty("roleCode")
            .map(roleName).toProperty("roleName")
            .map(note).toProperty("note")
            .map(order).toProperty("order")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<UcRole> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ucRole, c ->
            c.map(id).toProperty("id")
            .map(roleCode).toProperty("roleCode")
            .map(roleName).toProperty("roleName")
            .map(note).toProperty("note")
            .map(order).toProperty("order")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(UcRole row) {
        return MyBatis3Utils.insert(this::insert, row, ucRole, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(roleCode).toPropertyWhenPresent("roleCode", row::getRoleCode)
            .map(roleName).toPropertyWhenPresent("roleName", row::getRoleName)
            .map(note).toPropertyWhenPresent("note", row::getNote)
            .map(order).toPropertyWhenPresent("order", row::getOrder)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcRole> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ucRole, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcRole> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ucRole, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcRole> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ucRole, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcRole> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ucRole, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(UcRole row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(roleCode).equalTo(row::getRoleCode)
                .set(roleName).equalTo(row::getRoleName)
                .set(note).equalTo(row::getNote)
                .set(order).equalTo(row::getOrder);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UcRole row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(roleCode).equalToWhenPresent(row::getRoleCode)
                .set(roleName).equalToWhenPresent(row::getRoleName)
                .set(note).equalToWhenPresent(row::getNote)
                .set(order).equalToWhenPresent(row::getOrder);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(UcRole row) {
        return update(c ->
            c.set(roleCode).equalTo(row::getRoleCode)
            .set(roleName).equalTo(row::getRoleName)
            .set(note).equalTo(row::getNote)
            .set(order).equalTo(row::getOrder)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(UcRole row) {
        return update(c ->
            c.set(roleCode).equalToWhenPresent(row::getRoleCode)
            .set(roleName).equalToWhenPresent(row::getRoleName)
            .set(note).equalToWhenPresent(row::getNote)
            .set(order).equalToWhenPresent(row::getOrder)
            .where(id, isEqualTo(row::getId))
        );
    }
}