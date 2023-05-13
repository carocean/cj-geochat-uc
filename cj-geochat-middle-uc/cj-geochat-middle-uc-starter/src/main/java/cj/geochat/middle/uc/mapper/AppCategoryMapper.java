package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.AppCategoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.AppCategory;
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
public interface AppCategoryMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<AppCategory>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, cateCode, cateName, cateDesc, order);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AppCategoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="cate_code", property="cateCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="cate_name", property="cateName", jdbcType=JdbcType.VARCHAR),
        @Result(column="cate_desc", property="cateDesc", jdbcType=JdbcType.VARCHAR),
        @Result(column="order", property="order", jdbcType=JdbcType.INTEGER)
    })
    List<AppCategory> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AppCategoryResult")
    Optional<AppCategory> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, appCategory, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, appCategory, completer);
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
    default int insert(AppCategory row) {
        return MyBatis3Utils.insert(this::insert, row, appCategory, c ->
            c.map(id).toProperty("id")
            .map(cateCode).toProperty("cateCode")
            .map(cateName).toProperty("cateName")
            .map(cateDesc).toProperty("cateDesc")
            .map(order).toProperty("order")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<AppCategory> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, appCategory, c ->
            c.map(id).toProperty("id")
            .map(cateCode).toProperty("cateCode")
            .map(cateName).toProperty("cateName")
            .map(cateDesc).toProperty("cateDesc")
            .map(order).toProperty("order")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(AppCategory row) {
        return MyBatis3Utils.insert(this::insert, row, appCategory, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(cateCode).toPropertyWhenPresent("cateCode", row::getCateCode)
            .map(cateName).toPropertyWhenPresent("cateName", row::getCateName)
            .map(cateDesc).toPropertyWhenPresent("cateDesc", row::getCateDesc)
            .map(order).toPropertyWhenPresent("order", row::getOrder)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<AppCategory> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, appCategory, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<AppCategory> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, appCategory, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<AppCategory> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, appCategory, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<AppCategory> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, appCategory, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(AppCategory row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(cateCode).equalTo(row::getCateCode)
                .set(cateName).equalTo(row::getCateName)
                .set(cateDesc).equalTo(row::getCateDesc)
                .set(order).equalTo(row::getOrder);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AppCategory row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(cateCode).equalToWhenPresent(row::getCateCode)
                .set(cateName).equalToWhenPresent(row::getCateName)
                .set(cateDesc).equalToWhenPresent(row::getCateDesc)
                .set(order).equalToWhenPresent(row::getOrder);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(AppCategory row) {
        return update(c ->
            c.set(cateCode).equalTo(row::getCateCode)
            .set(cateName).equalTo(row::getCateName)
            .set(cateDesc).equalTo(row::getCateDesc)
            .set(order).equalTo(row::getOrder)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(AppCategory row) {
        return update(c ->
            c.set(cateCode).equalToWhenPresent(row::getCateCode)
            .set(cateName).equalToWhenPresent(row::getCateName)
            .set(cateDesc).equalToWhenPresent(row::getCateDesc)
            .set(order).equalToWhenPresent(row::getOrder)
            .where(id, isEqualTo(row::getId))
        );
    }
}