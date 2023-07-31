package cj.geochat.uc.middle.service;

import cj.geochat.ability.mybatis.config.AccessDBPolicy;
import cj.geochat.ability.util.GeochatRuntimeException;
import cj.geochat.uc.middle.mapper.*;
import cj.geochat.uc.middle.model.PaAppAuthority;
import cj.geochat.uc.middle.model.UcRole;
import cj.geochat.uc.middle.model.UcUser;
import cj.geochat.uc.middle.model.UcUserRole;
import com.github.f4b6a3.ulid.UlidCreator;
import jakarta.annotation.Resource;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoleService implements IRoleService {
    @Resource
    UcRoleMapper roleMapper;
    @Resource
    UcUserRoleMapper userRoleMapper;
    @Resource
    UcUserMapper userMapper;
    @Resource
    PaAppAuthorityMapper paAppAuthorityMapper;

    @Transactional
    @Override
    public String createRole(String roleCode, String roleName, int order, String note) {
        UcRole role = new UcRole();
        role.setId(UlidCreator.getUlid().toLowerCase());
        role.setRoleCode(roleCode);
        role.setRoleName(roleName);
        role.setOrder(order);
        role.setNote(note);
        roleMapper.insert(role);
        return role.getId();
    }

    @Transactional
    @Override
    public void removeRole(String roleId) {
        roleMapper.deleteByPrimaryKey(roleId);
    }

    @Transactional
    @Override
    public void addRoleToUser(String roleId, String userId) {
        UcUserRole ucUserRole = new UcUserRole();
        ucUserRole.setId(UlidCreator.getUlid().toLowerCase());
        ucUserRole.setUserId(userId);
        ucUserRole.setRoleId(roleId);
        userRoleMapper.insert(ucUserRole);
    }

    @Transactional
    @Override
    public void addRoleByCodeToUser(String roleCode, String userId) {
        UcRole role = getRoleByCode(roleCode);
        if (role == null) {
            throw new GeochatRuntimeException("4004", String.format("Role %s does not exist", roleCode));
        }
        addRoleToUser(role.getId(), userId);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcRole getRoleByCode(String roleCode) {
        return roleMapper.select(c -> c
                .where(UcRoleDynamicSqlSupport.roleCode, SqlBuilder.isEqualTo(roleCode))
        ).stream().findAny().orElse(null);
    }

    @Transactional
    @Override
    public void removeRoleFromUser(String roleId, String userId) {
        userRoleMapper.delete(c -> c
                .where(UcUserRoleDynamicSqlSupport.roleId, SqlBuilder.isEqualTo(roleId))
                .and(UcUserRoleDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId)));
    }

    @Transactional
    @Override
    public void emptyRoleOfUser(String userId) {
        userRoleMapper.delete(c -> c
                .where(UcUserRoleDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
        );
    }

    @Transactional
    @Override
    public void emptyUserOfRole(String roleId) {
        userRoleMapper.delete(c -> c
                .where(UcUserRoleDynamicSqlSupport.roleId, SqlBuilder.isEqualTo(roleId))
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public UcRole getRole(String roleId) {
        return roleMapper.selectByPrimaryKey(roleId).orElse(null);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcRole> listRole(int limit, long offset) {
        return roleMapper.select(c -> c
                .orderBy(UcRoleDynamicSqlSupport.order)
                .limit(limit).offset(offset)
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<String> listRoleCodeByUser(String userId) {
        SelectStatementProvider provider = SqlBuilder
                .select(UcRoleDynamicSqlSupport.ucRole.allColumns())
                .from(UcRoleDynamicSqlSupport.ucRole, "role")
                .join(UcUserRoleDynamicSqlSupport.ucUserRole, "ur")
                .on(UcUserRoleDynamicSqlSupport.roleId, SqlBuilder.equalTo(UcRoleDynamicSqlSupport.id))
                .where(UcUserRoleDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                .orderBy(UcRoleDynamicSqlSupport.order)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return roleMapper.selectMany(provider).stream().map(e -> e.getRoleCode()).collect(Collectors.toList());
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcRole> listRoleByUser(String userId) {
        SelectStatementProvider provider = SqlBuilder
                .select(UcRoleDynamicSqlSupport.ucRole.allColumns())
                .from(UcRoleDynamicSqlSupport.ucRole, "role")
                .join(UcUserRoleDynamicSqlSupport.ucUserRole, "ur")
                .on(UcUserRoleDynamicSqlSupport.roleId, SqlBuilder.equalTo(UcRoleDynamicSqlSupport.id))
                .where(UcUserRoleDynamicSqlSupport.userId, SqlBuilder.isEqualTo(userId))
                .orderBy(UcRoleDynamicSqlSupport.order)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return roleMapper.selectMany(provider);
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<UcUser> listUserByRole(String roleId) {
        return userMapper.selectMany(SqlBuilder
                .select(UcUserDynamicSqlSupport.ucUser.allColumns())
                .from(UcUserDynamicSqlSupport.ucUser, "user")
                .join(UcUserRoleDynamicSqlSupport.ucUserRole, "ur")
                .on(UcUserRoleDynamicSqlSupport.roleId, SqlBuilder.equalTo(UcUserDynamicSqlSupport.id))
                .where(UcUserRoleDynamicSqlSupport.roleId, SqlBuilder.isEqualTo(roleId))
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );
    }

    @Transactional
    @Override
    public void addAuthorityToApp(String roleId, String appId) {
        PaAppAuthority paAppAuthority = new PaAppAuthority();
        paAppAuthority.setId(UlidCreator.getUlid().toLowerCase());
        paAppAuthority.setAppId(appId);
        paAppAuthority.setRoleId(roleId);
        paAppAuthorityMapper.insertSelective(paAppAuthority);
    }

    @Transactional
    @Override
    public void removeAuthorityFromApp(String roleId, String appId) {
        paAppAuthorityMapper.delete(c -> c
                .where(PaAppAuthorityDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
                .and(PaAppAuthorityDynamicSqlSupport.roleId, SqlBuilder.isEqualTo(roleId))
        );
    }

    @AccessDBPolicy.ReadOnly
    @Override
    public List<String> listAuthorityCodeOfApp(String appId) {
        return roleMapper.selectMany(SqlBuilder.select(UcRoleDynamicSqlSupport.ucRole.allColumns())
                .from(UcRoleDynamicSqlSupport.ucRole)
                .join(PaAppAuthorityDynamicSqlSupport.paAppAuthority)
                .on(PaAppAuthorityDynamicSqlSupport.roleId, SqlBuilder.equalTo(UcRoleDynamicSqlSupport.id))
                .where(PaAppAuthorityDynamicSqlSupport.appId, SqlBuilder.isEqualTo(appId))
                .orderBy(UcRoleDynamicSqlSupport.order)
                .build().render(RenderingStrategies.MYBATIS3)
        ).stream().map(e -> e.getRoleCode()).collect(Collectors.toList());
    }
}
