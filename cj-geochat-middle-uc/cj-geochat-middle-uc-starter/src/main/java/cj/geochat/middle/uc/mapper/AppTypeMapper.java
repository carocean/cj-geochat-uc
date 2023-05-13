package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.AppTypeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.AppType;
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
public interface AppTypeMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<AppType>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, typeCode, typeName, typeDesc);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AppTypeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="type_code", property="typeCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_name", property="typeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type_desc", property="typeDesc", jdbcType=JdbcType.VARCHAR)
    })
    List<AppType> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AppTypeResult")
    Optional<AppType> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, appType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, appType, completer);
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
    default int insert(AppType row) {
        return MyBatis3Utils.insert(this::insert, row, appType, c ->
            c.map(id).toProperty("id")
            .map(typeCode).toProperty("typeCode")
            .map(typeName).toProperty("typeName")
            .map(typeDesc).toProperty("typeDesc")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<AppType> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, appType, c ->
            c.map(id).toProperty("id")
            .map(typeCode).toProperty("typeCode")
            .map(typeName).toProperty("typeName")
            .map(typeDesc).toProperty("typeDesc")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(AppType row) {
        return MyBatis3Utils.insert(this::insert, row, appType, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(typeCode).toPropertyWhenPresent("typeCode", row::getTypeCode)
            .map(typeName).toPropertyWhenPresent("typeName", row::getTypeName)
            .map(typeDesc).toPropertyWhenPresent("typeDesc", row::getTypeDesc)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<AppType> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, appType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<AppType> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, appType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<AppType> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, appType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<AppType> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, appType, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(AppType row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(typeCode).equalTo(row::getTypeCode)
                .set(typeName).equalTo(row::getTypeName)
                .set(typeDesc).equalTo(row::getTypeDesc);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AppType row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(typeCode).equalToWhenPresent(row::getTypeCode)
                .set(typeName).equalToWhenPresent(row::getTypeName)
                .set(typeDesc).equalToWhenPresent(row::getTypeDesc);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(AppType row) {
        return update(c ->
            c.set(typeCode).equalTo(row::getTypeCode)
            .set(typeName).equalTo(row::getTypeName)
            .set(typeDesc).equalTo(row::getTypeDesc)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(AppType row) {
        return update(c ->
            c.set(typeCode).equalToWhenPresent(row::getTypeCode)
            .set(typeName).equalToWhenPresent(row::getTypeName)
            .set(typeDesc).equalToWhenPresent(row::getTypeDesc)
            .where(id, isEqualTo(row::getId))
        );
    }
}