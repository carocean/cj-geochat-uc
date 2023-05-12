package cj.geochat.middle.uc.service;

import cj.geochat.middle.uc.model.UcRole;
import cj.geochat.middle.uc.model.UcUser;

import java.util.List;

public interface IRoleService {
    void addRole(UcRole role);

    void removeRole(String roleId);

    void addRoleToUser(String roleId, String userId);

    void removeRoleFromUser(String roleId, String userId);

    void emptyRoleOfUser(String userId);

    void emptyUserOfRole(String roleId);

    UcRole getRole(String roleId);

    List<UcRole> listRole(int limit, long offset);

    List<UcRole> listRoleByUser(String userId);

    List<UcUser> listUserByRole(String roleId);

}
