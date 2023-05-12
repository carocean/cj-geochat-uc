package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.SysPropsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.SysProps;
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
public interface SysPropsMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<SysProps>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, map, key, value, note);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="SysPropsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="map", property="map", jdbcType=JdbcType.VARCHAR),
        @Result(column="key", property="key", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR)
    })
    List<SysProps> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("SysPropsResult")
    Optional<SysProps> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, sysProps, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, sysProps, completer);
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
    default int insert(SysProps row) {
        return MyBatis3Utils.insert(this::insert, row, sysProps, c ->
            c.map(id).toProperty("id")
            .map(map).toProperty("map")
            .map(key).toProperty("key")
            .map(value).toProperty("value")
            .map(note).toProperty("note")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<SysProps> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, sysProps, c ->
            c.map(id).toProperty("id")
            .map(map).toProperty("map")
            .map(key).toProperty("key")
            .map(value).toProperty("value")
            .map(note).toProperty("note")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(SysProps row) {
        return MyBatis3Utils.insert(this::insert, row, sysProps, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(map).toPropertyWhenPresent("map", row::getMap)
            .map(key).toPropertyWhenPresent("key", row::getKey)
            .map(value).toPropertyWhenPresent("value", row::getValue)
            .map(note).toPropertyWhenPresent("note", row::getNote)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<SysProps> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, sysProps, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<SysProps> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, sysProps, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<SysProps> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, sysProps, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<SysProps> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, sysProps, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(SysProps row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(map).equalTo(row::getMap)
                .set(key).equalTo(row::getKey)
                .set(value).equalTo(row::getValue)
                .set(note).equalTo(row::getNote);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(SysProps row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(map).equalToWhenPresent(row::getMap)
                .set(key).equalToWhenPresent(row::getKey)
                .set(value).equalToWhenPresent(row::getValue)
                .set(note).equalToWhenPresent(row::getNote);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(SysProps row) {
        return update(c ->
            c.set(map).equalTo(row::getMap)
            .set(key).equalTo(row::getKey)
            .set(value).equalTo(row::getValue)
            .set(note).equalTo(row::getNote)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(SysProps row) {
        return update(c ->
            c.set(map).equalToWhenPresent(row::getMap)
            .set(key).equalToWhenPresent(row::getKey)
            .set(value).equalToWhenPresent(row::getValue)
            .set(note).equalToWhenPresent(row::getNote)
            .where(id, isEqualTo(row::getId))
        );
    }
}