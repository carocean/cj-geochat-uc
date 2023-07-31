package cj.geochat.uc.middle.web.rest;

import cj.geochat.ability.api.annotation.ApiResult;
import cj.geochat.uc.middle.model.UcRole;
import cj.geochat.uc.middle.model.UcUser;
import cj.geochat.uc.middle.service.IRoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/role")
@Tag(name = "角色管理")
public class RoleRestfull implements IRoleRestfull {
    @Autowired
    IRoleService roleService;

    @GetMapping("/createRole")
    @ApiResult
    @Operation(summary = "创建角色")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public String createRole(String roleCode, String roleName, int order, @RequestParam(required = false) String note) {
        return roleService.createRole(roleCode, roleName, order, note);
    }

    @GetMapping("/removeRole")
    @ApiResult
    @Operation(summary = "移除角色")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeRole(String roleId) {
        roleService.removeRole(roleId);
    }

    @GetMapping("/addRoleToUser")
    @ApiResult
    @Operation(summary = "添加角色到用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addRoleToUser(String roleId, String userId) {
        roleService.addRoleToUser(roleId, userId);
    }

    @GetMapping("/addRoleByCodeToUser")
    @ApiResult
    @Operation(summary = "通过角色代码添加角色到用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addRoleByCodeToUser(String roleCode, String userId) {
        roleService.addRoleByCodeToUser(roleCode, userId);
    }

    @GetMapping("/getRoleByCode")
    @ApiResult
    @Operation(summary = "按指定角色代码获取角色")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcRole getRoleByCode(String roleCode) {
        return roleService.getRoleByCode(roleCode);
    }

    @GetMapping("/removeRoleFromUser")
    @ApiResult
    @Operation(summary = "移除角色从用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeRoleFromUser(String roleId, String userId) {
        roleService.removeRoleFromUser(roleId, userId);
    }

    @GetMapping("/emptyRoleOfUser")
    @ApiResult
    @Operation(summary = "清空指定用户的所有角色")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void emptyRoleOfUser(String userId) {
        roleService.emptyRoleOfUser(userId);
    }

    @GetMapping("/emptyUserOfRole")
    @ApiResult
    @Operation(summary = "清空指定角色的所有用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void emptyUserOfRole(String roleId) {
        roleService.emptyUserOfRole(roleId);
    }

    @GetMapping("/getRole")
    @ApiResult
    @Operation(summary = "获取角色")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public UcRole getRole(String roleId) {
        return roleService.getRole(roleId);
    }

    @GetMapping("/listRole")
    @ApiResult
    @Operation(summary = "列出角色")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcRole> listRole(int limit, long offset) {
        return roleService.listRole(limit, offset);
    }

    @GetMapping("/listRoleByUser")
    @ApiResult
    @Operation(summary = "列出指定用户的所有角色")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcRole> listRoleByUser(String userId) {
        return roleService.listRoleByUser(userId);
    }

    @GetMapping("/listUserByRole")
    @ApiResult
    @Operation(summary = "列出指定角色的所有用户")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<UcUser> listUserByRole(String roleId) {
        return roleService.listUserByRole(roleId);
    }

    @GetMapping("/addAuthorityToApp")
    @ApiResult
    @Operation(summary = "添加授权到应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void addAuthorityToApp(String roleId, String appId) {
        roleService.addAuthorityToApp(roleId, appId);
    }

    @GetMapping("/removeAuthorityFromApp")
    @ApiResult
    @Operation(summary = "移除授权从应用")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public void removeAuthorityFromApp(String roleId, String appId) {
        roleService.removeAuthorityFromApp(roleId, appId);
    }

    @GetMapping("/listAuthorityCodeOfApp")
    @ApiResult
    @Operation(summary = "列出应用的授权")
    @ApiResponses({@ApiResponse(responseCode = "2000", description = "ok")})
    @Override
    public List<String> listAuthorityCodeOfApp(String appId) {
        return roleService.listAuthorityCodeOfApp(appId);
    }
}
