package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcUserDynamicSqlSupport {
    public static final UcUser ucUser = new UcUser();

    public static final SqlColumn<String> id = ucUser.id;

    public static final SqlColumn<String> nickName = ucUser.nickName;

    public static final SqlColumn<String> realName = ucUser.realName;

    public static final SqlColumn<String> userIntro = ucUser.userIntro;

    public static final SqlColumn<String> avatar = ucUser.avatar;

    public static final SqlColumn<String> email = ucUser.email;

    public static final SqlColumn<String> phone = ucUser.phone;

    public static final SqlColumn<String> password = ucUser.password;

    public static final SqlColumn<String> salt = ucUser.salt;

    public static final SqlColumn<String> majorAccount = ucUser.majorAccount;

    public static final SqlColumn<Byte> status = ucUser.status;

    public static final SqlColumn<String> lastLoginTime = ucUser.lastLoginTime;

    public static final SqlColumn<String> updatePwdTime = ucUser.updatePwdTime;

    public static final SqlColumn<String> ctime = ucUser.ctime;

    public static final class UcUser extends AliasableSqlTable<UcUser> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> nickName = column("nick_name", JDBCType.VARCHAR);

        public final SqlColumn<String> realName = column("real_name", JDBCType.VARCHAR);

        public final SqlColumn<String> userIntro = column("user_intro", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> email = column("email", JDBCType.VARCHAR);

        public final SqlColumn<String> phone = column("phone", JDBCType.VARCHAR);

        public final SqlColumn<String> password = column("`password`", JDBCType.VARCHAR);

        public final SqlColumn<String> salt = column("salt", JDBCType.VARCHAR);

        public final SqlColumn<String> majorAccount = column("major_account", JDBCType.VARCHAR);

        public final SqlColumn<Byte> status = column("`status`", JDBCType.TINYINT);

        public final SqlColumn<String> lastLoginTime = column("last_login_time", JDBCType.VARCHAR);

        public final SqlColumn<String> updatePwdTime = column("update_pwd_time", JDBCType.VARCHAR);

        public final SqlColumn<String> ctime = column("ctime", JDBCType.VARCHAR);

        public UcUser() {
            super("uc_user", UcUser::new);
        }
    }
}