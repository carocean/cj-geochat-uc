package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcWechatDynamicSqlSupport {
    public static final UcWechat ucWechat = new UcWechat();

    public static final SqlColumn<String> id = ucWechat.id;

    public static final SqlColumn<String> openid = ucWechat.openid;

    public static final SqlColumn<String> nickName = ucWechat.nickName;

    public static final SqlColumn<Integer> sex = ucWechat.sex;

    public static final SqlColumn<String> language = ucWechat.language;

    public static final SqlColumn<String> city = ucWechat.city;

    public static final SqlColumn<String> province = ucWechat.province;

    public static final SqlColumn<String> country = ucWechat.country;

    public static final SqlColumn<String> headimgurl = ucWechat.headimgurl;

    public static final SqlColumn<String> userId = ucWechat.userId;

    public static final class UcWechat extends AliasableSqlTable<UcWechat> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> openid = column("openid", JDBCType.VARCHAR);

        public final SqlColumn<String> nickName = column("nick_name", JDBCType.VARCHAR);

        public final SqlColumn<Integer> sex = column("sex", JDBCType.INTEGER);

        public final SqlColumn<String> language = column("`language`", JDBCType.VARCHAR);

        public final SqlColumn<String> city = column("city", JDBCType.VARCHAR);

        public final SqlColumn<String> province = column("province", JDBCType.VARCHAR);

        public final SqlColumn<String> country = column("country", JDBCType.VARCHAR);

        public final SqlColumn<String> headimgurl = column("headimgurl", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public UcWechat() {
            super("uc_wechat", UcWechat::new);
        }
    }
}