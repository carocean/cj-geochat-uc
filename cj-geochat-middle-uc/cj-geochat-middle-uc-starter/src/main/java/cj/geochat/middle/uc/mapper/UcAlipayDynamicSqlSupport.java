package cj.geochat.middle.uc.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcAlipayDynamicSqlSupport {
    public static final UcAlipay ucAlipay = new UcAlipay();

    public static final SqlColumn<String> id = ucAlipay.id;

    public static final SqlColumn<String> openId = ucAlipay.openId;

    public static final SqlColumn<String> nickName = ucAlipay.nickName;

    public static final SqlColumn<String> avatar = ucAlipay.avatar;

    public static final SqlColumn<String> gender = ucAlipay.gender;

    public static final SqlColumn<String> city = ucAlipay.city;

    public static final SqlColumn<String> province = ucAlipay.province;

    public static final SqlColumn<String> userId = ucAlipay.userId;

    public static final class UcAlipay extends AliasableSqlTable<UcAlipay> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> openId = column("open_id", JDBCType.VARCHAR);

        public final SqlColumn<String> nickName = column("nick_name", JDBCType.VARCHAR);

        public final SqlColumn<String> avatar = column("avatar", JDBCType.VARCHAR);

        public final SqlColumn<String> gender = column("gender", JDBCType.VARCHAR);

        public final SqlColumn<String> city = column("city", JDBCType.VARCHAR);

        public final SqlColumn<String> province = column("province", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public UcAlipay() {
            super("uc_alipay", UcAlipay::new);
        }
    }
}