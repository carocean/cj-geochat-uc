package cj.geochat.uc.middle.service;

import cj.geochat.uc.middle.model.UcRole;
import cj.geochat.uc.middle.model.UcUser;

import java.util.List;

public interface IRoleService {
    String createRole(String roleCode,String roleName,int order,String note);

    void removeRole(String roleId);

    void addRoleToUser(String roleId, String userId);

    void addRoleByCodeToUser(String roleCode, String userId);

    UcRole getRoleByCode(String roleCode);

    void removeRoleFromUser(String roleId, String userId);

    void emptyRoleOfUser(String userId);

    void emptyUserOfRole(String roleId);

    UcRole getRole(String roleId);

    List<UcRole> listRole(int limit, long offset);

    List<UcRole> listRoleByUser(String userId);

    List<UcUser> listUserByRole(String roleId);


    void addAuthorityToApp(String roleId, String appId);

    void removeAuthorityFromApp(String roleId, String appId);

    List<String> listAuthorityCodeOfApp(String appId);


    List<String> listRoleCodeByUser(String userId);

}
