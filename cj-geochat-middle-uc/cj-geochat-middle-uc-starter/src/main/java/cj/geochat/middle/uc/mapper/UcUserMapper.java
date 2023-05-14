package cj.geochat.middle.uc.mapper;

import static cj.geochat.middle.uc.mapper.UcUserDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

import cj.geochat.middle.uc.model.UcUser;
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
public interface UcUserMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<UcUser>, CommonUpdateMapper {
    /**
     * @mbg.generated generated automatically, do not modify!
     */
    BasicColumn[] selectList = BasicColumn.columnList(id, nickName, realName, userIntro, avatar, email, phone, password, majorAccount, status, lastLoginTime, updatePwdTime, ctime, countryCode, countrName, agreeUpa);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UcUserResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="nick_name", property="nickName", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_intro", property="userIntro", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="major_account", property="majorAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_login_time", property="lastLoginTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_pwd_time", property="updatePwdTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="ctime", property="ctime", jdbcType=JdbcType.VARCHAR),
        @Result(column="country_code", property="countryCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="countr_name", property="countrName", jdbcType=JdbcType.VARCHAR),
        @Result(column="agree_upa", property="agreeUpa", jdbcType=JdbcType.BIT)
    })
    List<UcUser> selectMany(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UcUserResult")
    Optional<UcUser> selectOne(SelectStatementProvider selectStatement);

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, ucUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, ucUser, completer);
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
    default int insert(UcUser row) {
        return MyBatis3Utils.insert(this::insert, row, ucUser, c ->
            c.map(id).toProperty("id")
            .map(nickName).toProperty("nickName")
            .map(realName).toProperty("realName")
            .map(userIntro).toProperty("userIntro")
            .map(avatar).toProperty("avatar")
            .map(email).toProperty("email")
            .map(phone).toProperty("phone")
            .map(password).toProperty("password")
            .map(majorAccount).toProperty("majorAccount")
            .map(status).toProperty("status")
            .map(lastLoginTime).toProperty("lastLoginTime")
            .map(updatePwdTime).toProperty("updatePwdTime")
            .map(ctime).toProperty("ctime")
            .map(countryCode).toProperty("countryCode")
            .map(countrName).toProperty("countrName")
            .map(agreeUpa).toProperty("agreeUpa")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertMultiple(Collection<UcUser> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, ucUser, c ->
            c.map(id).toProperty("id")
            .map(nickName).toProperty("nickName")
            .map(realName).toProperty("realName")
            .map(userIntro).toProperty("userIntro")
            .map(avatar).toProperty("avatar")
            .map(email).toProperty("email")
            .map(phone).toProperty("phone")
            .map(password).toProperty("password")
            .map(majorAccount).toProperty("majorAccount")
            .map(status).toProperty("status")
            .map(lastLoginTime).toProperty("lastLoginTime")
            .map(updatePwdTime).toProperty("updatePwdTime")
            .map(ctime).toProperty("ctime")
            .map(countryCode).toProperty("countryCode")
            .map(countrName).toProperty("countrName")
            .map(agreeUpa).toProperty("agreeUpa")
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int insertSelective(UcUser row) {
        return MyBatis3Utils.insert(this::insert, row, ucUser, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(nickName).toPropertyWhenPresent("nickName", row::getNickName)
            .map(realName).toPropertyWhenPresent("realName", row::getRealName)
            .map(userIntro).toPropertyWhenPresent("userIntro", row::getUserIntro)
            .map(avatar).toPropertyWhenPresent("avatar", row::getAvatar)
            .map(email).toPropertyWhenPresent("email", row::getEmail)
            .map(phone).toPropertyWhenPresent("phone", row::getPhone)
            .map(password).toPropertyWhenPresent("password", row::getPassword)
            .map(majorAccount).toPropertyWhenPresent("majorAccount", row::getMajorAccount)
            .map(status).toPropertyWhenPresent("status", row::getStatus)
            .map(lastLoginTime).toPropertyWhenPresent("lastLoginTime", row::getLastLoginTime)
            .map(updatePwdTime).toPropertyWhenPresent("updatePwdTime", row::getUpdatePwdTime)
            .map(ctime).toPropertyWhenPresent("ctime", row::getCtime)
            .map(countryCode).toPropertyWhenPresent("countryCode", row::getCountryCode)
            .map(countrName).toPropertyWhenPresent("countrName", row::getCountrName)
            .map(agreeUpa).toPropertyWhenPresent("agreeUpa", row::getAgreeUpa)
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcUser> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, ucUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcUser> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, ucUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default List<UcUser> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, ucUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default Optional<UcUser> selectByPrimaryKey(String id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, ucUser, completer);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateAllColumns(UcUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(nickName).equalTo(row::getNickName)
                .set(realName).equalTo(row::getRealName)
                .set(userIntro).equalTo(row::getUserIntro)
                .set(avatar).equalTo(row::getAvatar)
                .set(email).equalTo(row::getEmail)
                .set(phone).equalTo(row::getPhone)
                .set(password).equalTo(row::getPassword)
                .set(majorAccount).equalTo(row::getMajorAccount)
                .set(status).equalTo(row::getStatus)
                .set(lastLoginTime).equalTo(row::getLastLoginTime)
                .set(updatePwdTime).equalTo(row::getUpdatePwdTime)
                .set(ctime).equalTo(row::getCtime)
                .set(countryCode).equalTo(row::getCountryCode)
                .set(countrName).equalTo(row::getCountrName)
                .set(agreeUpa).equalTo(row::getAgreeUpa);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    static UpdateDSL<UpdateModel> updateSelectiveColumns(UcUser row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(nickName).equalToWhenPresent(row::getNickName)
                .set(realName).equalToWhenPresent(row::getRealName)
                .set(userIntro).equalToWhenPresent(row::getUserIntro)
                .set(avatar).equalToWhenPresent(row::getAvatar)
                .set(email).equalToWhenPresent(row::getEmail)
                .set(phone).equalToWhenPresent(row::getPhone)
                .set(password).equalToWhenPresent(row::getPassword)
                .set(majorAccount).equalToWhenPresent(row::getMajorAccount)
                .set(status).equalToWhenPresent(row::getStatus)
                .set(lastLoginTime).equalToWhenPresent(row::getLastLoginTime)
                .set(updatePwdTime).equalToWhenPresent(row::getUpdatePwdTime)
                .set(ctime).equalToWhenPresent(row::getCtime)
                .set(countryCode).equalToWhenPresent(row::getCountryCode)
                .set(countrName).equalToWhenPresent(row::getCountrName)
                .set(agreeUpa).equalToWhenPresent(row::getAgreeUpa);
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKey(UcUser row) {
        return update(c ->
            c.set(nickName).equalTo(row::getNickName)
            .set(realName).equalTo(row::getRealName)
            .set(userIntro).equalTo(row::getUserIntro)
            .set(avatar).equalTo(row::getAvatar)
            .set(email).equalTo(row::getEmail)
            .set(phone).equalTo(row::getPhone)
            .set(password).equalTo(row::getPassword)
            .set(majorAccount).equalTo(row::getMajorAccount)
            .set(status).equalTo(row::getStatus)
            .set(lastLoginTime).equalTo(row::getLastLoginTime)
            .set(updatePwdTime).equalTo(row::getUpdatePwdTime)
            .set(ctime).equalTo(row::getCtime)
            .set(countryCode).equalTo(row::getCountryCode)
            .set(countrName).equalTo(row::getCountrName)
            .set(agreeUpa).equalTo(row::getAgreeUpa)
            .where(id, isEqualTo(row::getId))
        );
    }

    /**
     * @mbg.generated generated automatically, do not modify!
     */
    default int updateByPrimaryKeySelective(UcUser row) {
        return update(c ->
            c.set(nickName).equalToWhenPresent(row::getNickName)
            .set(realName).equalToWhenPresent(row::getRealName)
            .set(userIntro).equalToWhenPresent(row::getUserIntro)
            .set(avatar).equalToWhenPresent(row::getAvatar)
            .set(email).equalToWhenPresent(row::getEmail)
            .set(phone).equalToWhenPresent(row::getPhone)
            .set(password).equalToWhenPresent(row::getPassword)
            .set(majorAccount).equalToWhenPresent(row::getMajorAccount)
            .set(status).equalToWhenPresent(row::getStatus)
            .set(lastLoginTime).equalToWhenPresent(row::getLastLoginTime)
            .set(updatePwdTime).equalToWhenPresent(row::getUpdatePwdTime)
            .set(ctime).equalToWhenPresent(row::getCtime)
            .set(countryCode).equalToWhenPresent(row::getCountryCode)
            .set(countrName).equalToWhenPresent(row::getCountrName)
            .set(agreeUpa).equalToWhenPresent(row::getAgreeUpa)
            .where(id, isEqualTo(row::getId))
        );
    }
}