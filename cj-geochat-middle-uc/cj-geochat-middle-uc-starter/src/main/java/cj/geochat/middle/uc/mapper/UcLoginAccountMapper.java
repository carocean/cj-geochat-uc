package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.UcLoginAccountDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.UcLoginAccount;
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
public interface UcLoginAccountMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UcLoginAccount>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, userId, openCode, category, ctime);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UcLoginAccountResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_code", property="openCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="category", property="category", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.VARCHAR)
    })
    List<UcLoginAccount> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UcLoginAccountResult")
    Optional<UcLoginAccount> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ucLoginAccount, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ucLoginAccount, completer);
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
    default int insert(UcLoginAccount row) {
        return MyBatis3Utils.insert(this::insert, row, ucLoginAccount, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(openCode).toProperty("openCode")
            .map(category).toProperty("category")
            .map(ctime).toProperty("ctime")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<UcLoginAccount> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ucLoginAccount, c ->
            c.map(id).toProperty("id")
            .map(userId).toProperty("userId")
            .map(openCode).toProperty("openCode")
            .map(category).toProperty("category")
            .map(ctime).toProperty("ctime")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(UcLoginAccount row) {
        return MyBatis3Utils.insert(this::insert, row, ucLoginAccount, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(userId).toPropertyWhenPresent("userId", row::getUserId)
            .map(openCode).toPropertyWhenPresent("openCode", row::getOpenCode)
            .map(category).toPropertyWhenPresent("category", row::getCategory)
            .map(ctime).toPropertyWhenPresent("ctime", row::getCtime)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcLoginAccount> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ucLoginAccount, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcLoginAccount> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ucLoginAccount, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcLoginAccount> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ucLoginAccount, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcLoginAccount> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ucLoginAccount, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(UcLoginAccount row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(userId).equalTo(row::getUserId)
                .set(openCode).equalTo(row::getOpenCode)
                .set(category).equalTo(row::getCategory)
                .set(ctime).equalTo(row::getCtime);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UcLoginAccount row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(userId).equalToWhenPresent(row::getUserId)
                .set(openCode).equalToWhenPresent(row::getOpenCode)
                .set(category).equalToWhenPresent(row::getCategory)
                .set(ctime).equalToWhenPresent(row::getCtime);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(UcLoginAccount row) {
        return update(c ->
            c.set(userId).equalTo(row::getUserId)
            .set(openCode).equalTo(row::getOpenCode)
            .set(category).equalTo(row::getCategory)
            .set(ctime).equalTo(row::getCtime)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(UcLoginAccount row) {
        return update(c ->
            c.set(userId).equalToWhenPresent(row::getUserId)
            .set(openCode).equalToWhenPresent(row::getOpenCode)
            .set(category).equalToWhenPresent(row::getCategory)
            .set(ctime).equalToWhenPresent(row::getCtime)
            .where(id, isEqualTo(row::getId))
        );
    }
}