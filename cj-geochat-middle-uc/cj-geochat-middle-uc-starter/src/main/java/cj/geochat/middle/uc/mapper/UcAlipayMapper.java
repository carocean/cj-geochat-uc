package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.UcAlipayDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.UcAlipay;
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
public interface UcAlipayMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UcAlipay>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, openId, nickName, avatar, gender, city, province, userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UcAlipayResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR)
    })
    List<UcAlipay> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UcAlipayResult")
    Optional<UcAlipay> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ucAlipay, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ucAlipay, completer);
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
    default int insert(UcAlipay row) {
        return MyBatis3Utils.insert(this::insert, row, ucAlipay, c ->
            c.map(id).toProperty("id")
            .map(openId).toProperty("openId")
            .map(nickName).toProperty("nickName")
            .map(avatar).toProperty("avatar")
            .map(gender).toProperty("gender")
            .map(city).toProperty("city")
            .map(province).toProperty("province")
            .map(userId).toProperty("userId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<UcAlipay> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ucAlipay, c ->
            c.map(id).toProperty("id")
            .map(openId).toProperty("openId")
            .map(nickName).toProperty("nickName")
            .map(avatar).toProperty("avatar")
            .map(gender).toProperty("gender")
            .map(city).toProperty("city")
            .map(province).toProperty("province")
            .map(userId).toProperty("userId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(UcAlipay row) {
        return MyBatis3Utils.insert(this::insert, row, ucAlipay, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(openId).toPropertyWhenPresent("openId", row::getOpenId)
            .map(nickName).toPropertyWhenPresent("nickName", row::getNickName)
            .map(avatar).toPropertyWhenPresent("avatar", row::getAvatar)
            .map(gender).toPropertyWhenPresent("gender", row::getGender)
            .map(city).toPropertyWhenPresent("city", row::getCity)
            .map(province).toPropertyWhenPresent("province", row::getProvince)
            .map(userId).toPropertyWhenPresent("userId", row::getUserId)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcAlipay> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ucAlipay, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcAlipay> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ucAlipay, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcAlipay> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ucAlipay, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcAlipay> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ucAlipay, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(UcAlipay row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(openId).equalTo(row::getOpenId)
                .set(nickName).equalTo(row::getNickName)
                .set(avatar).equalTo(row::getAvatar)
                .set(gender).equalTo(row::getGender)
                .set(city).equalTo(row::getCity)
                .set(province).equalTo(row::getProvince)
                .set(userId).equalTo(row::getUserId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UcAlipay row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(openId).equalToWhenPresent(row::getOpenId)
                .set(nickName).equalToWhenPresent(row::getNickName)
                .set(avatar).equalToWhenPresent(row::getAvatar)
                .set(gender).equalToWhenPresent(row::getGender)
                .set(city).equalToWhenPresent(row::getCity)
                .set(province).equalToWhenPresent(row::getProvince)
                .set(userId).equalToWhenPresent(row::getUserId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(UcAlipay row) {
        return update(c ->
            c.set(openId).equalTo(row::getOpenId)
            .set(nickName).equalTo(row::getNickName)
            .set(avatar).equalTo(row::getAvatar)
            .set(gender).equalTo(row::getGender)
            .set(city).equalTo(row::getCity)
            .set(province).equalTo(row::getProvince)
            .set(userId).equalTo(row::getUserId)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(UcAlipay row) {
        return update(c ->
            c.set(openId).equalToWhenPresent(row::getOpenId)
            .set(nickName).equalToWhenPresent(row::getNickName)
            .set(avatar).equalToWhenPresent(row::getAvatar)
            .set(gender).equalToWhenPresent(row::getGender)
            .set(city).equalToWhenPresent(row::getCity)
            .set(province).equalToWhenPresent(row::getProvince)
            .set(userId).equalToWhenPresent(row::getUserId)
            .where(id, isEqualTo(row::getId))
        );
    }
}