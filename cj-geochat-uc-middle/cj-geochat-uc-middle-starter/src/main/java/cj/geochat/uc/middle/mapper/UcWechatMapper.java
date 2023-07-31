package cj.geochat.uc.middle.mapper;

import static cj.geochat.uc.middle.mapper.UcWechatDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.uc.middle.model.UcWechat;
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
public interface UcWechatMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UcWechat>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, openid, nickName, sex, language, city, province, country, headimgurl, userId);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UcWechatResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="sex", property="sex", jdbcType=JdbcType.INTEGER),
        @Result(column="language", property="language", jdbcType=JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType=JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType=JdbcType.VARCHAR),
        @Result(column="country", property="country", jdbcType=JdbcType.VARCHAR),
        @Result(column="headimgurl", property="headimgurl", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR)
    })
    List<UcWechat> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UcWechatResult")
    Optional<UcWechat> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ucWechat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ucWechat, completer);
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
    default int insert(UcWechat row) {
        return MyBatis3Utils.insert(this::insert, row, ucWechat, c ->
            c.map(id).toProperty("id")
            .map(openid).toProperty("openid")
            .map(nickName).toProperty("nickName")
            .map(sex).toProperty("sex")
            .map(language).toProperty("language")
            .map(city).toProperty("city")
            .map(province).toProperty("province")
            .map(country).toProperty("country")
            .map(headimgurl).toProperty("headimgurl")
            .map(userId).toProperty("userId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<UcWechat> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ucWechat, c ->
            c.map(id).toProperty("id")
            .map(openid).toProperty("openid")
            .map(nickName).toProperty("nickName")
            .map(sex).toProperty("sex")
            .map(language).toProperty("language")
            .map(city).toProperty("city")
            .map(province).toProperty("province")
            .map(country).toProperty("country")
            .map(headimgurl).toProperty("headimgurl")
            .map(userId).toProperty("userId")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(UcWechat row) {
        return MyBatis3Utils.insert(this::insert, row, ucWechat, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(openid).toPropertyWhenPresent("openid", row::getOpenid)
            .map(nickName).toPropertyWhenPresent("nickName", row::getNickName)
            .map(sex).toPropertyWhenPresent("sex", row::getSex)
            .map(language).toPropertyWhenPresent("language", row::getLanguage)
            .map(city).toPropertyWhenPresent("city", row::getCity)
            .map(province).toPropertyWhenPresent("province", row::getProvince)
            .map(country).toPropertyWhenPresent("country", row::getCountry)
            .map(headimgurl).toPropertyWhenPresent("headimgurl", row::getHeadimgurl)
            .map(userId).toPropertyWhenPresent("userId", row::getUserId)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcWechat> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ucWechat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcWechat> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ucWechat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcWechat> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ucWechat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcWechat> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ucWechat, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(UcWechat row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(openid).equalTo(row::getOpenid)
                .set(nickName).equalTo(row::getNickName)
                .set(sex).equalTo(row::getSex)
                .set(language).equalTo(row::getLanguage)
                .set(city).equalTo(row::getCity)
                .set(province).equalTo(row::getProvince)
                .set(country).equalTo(row::getCountry)
                .set(headimgurl).equalTo(row::getHeadimgurl)
                .set(userId).equalTo(row::getUserId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UcWechat row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(openid).equalToWhenPresent(row::getOpenid)
                .set(nickName).equalToWhenPresent(row::getNickName)
                .set(sex).equalToWhenPresent(row::getSex)
                .set(language).equalToWhenPresent(row::getLanguage)
                .set(city).equalToWhenPresent(row::getCity)
                .set(province).equalToWhenPresent(row::getProvince)
                .set(country).equalToWhenPresent(row::getCountry)
                .set(headimgurl).equalToWhenPresent(row::getHeadimgurl)
                .set(userId).equalToWhenPresent(row::getUserId);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(UcWechat row) {
        return update(c ->
            c.set(openid).equalTo(row::getOpenid)
            .set(nickName).equalTo(row::getNickName)
            .set(sex).equalTo(row::getSex)
            .set(language).equalTo(row::getLanguage)
            .set(city).equalTo(row::getCity)
            .set(province).equalTo(row::getProvince)
            .set(country).equalTo(row::getCountry)
            .set(headimgurl).equalTo(row::getHeadimgurl)
            .set(userId).equalTo(row::getUserId)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(UcWechat row) {
        return update(c ->
            c.set(openid).equalToWhenPresent(row::getOpenid)
            .set(nickName).equalToWhenPresent(row::getNickName)
            .set(sex).equalToWhenPresent(row::getSex)
            .set(language).equalToWhenPresent(row::getLanguage)
            .set(city).equalToWhenPresent(row::getCity)
            .set(province).equalToWhenPresent(row::getProvince)
            .set(country).equalToWhenPresent(row::getCountry)
            .set(headimgurl).equalToWhenPresent(row::getHeadimgurl)
            .set(userId).equalToWhenPresent(row::getUserId)
            .where(id, isEqualTo(row::getId))
        );
    }
}