package cj.geochat.uc.middle.mapper;

import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class UcLoginAccountDynamicSqlSupport {
    public static final UcLoginAccount ucLoginAccount = new UcLoginAccount();

    public static final SqlColumn<String> id = ucLoginAccount.id;

    public static final SqlColumn<String> userId = ucLoginAccount.userId;

    public static final SqlColumn<String> openCode = ucLoginAccount.openCode;

    public static final SqlColumn<String> category = ucLoginAccount.category;

    public static final SqlColumn<String> ctime = ucLoginAccount.ctime;

    public static final class UcLoginAccount extends AliasableSqlTable<UcLoginAccount> {
        public final SqlColumn<String> id = column("id", JDBCType.VARCHAR);

        public final SqlColumn<String> userId = column("user_id", JDBCType.VARCHAR);

        public final SqlColumn<String> openCode = column("open_code", JDBCType.VARCHAR);

        public final SqlColumn<String> category = column("category", JDBCType.VARCHAR);

        public final SqlColumn<String> ctime = column("ctime", JDBCType.VARCHAR);

        public UcLoginAccount() {
            super("uc_login_account", UcLoginAccount::new);
        }
    }
}