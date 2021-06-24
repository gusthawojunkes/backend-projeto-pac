package br.edu.catolicasc.pac.config.group.model;

import br.edu.catolicasc.pac.config.action.Action;
import br.edu.catolicasc.pac.config.action.model.ActionModel;
import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.pac.config.permission.Permission;
import br.edu.catolicasc.pac.config.permission.model.PermissionModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserGroupModel {

    private String name;

    private String description;

    @JsonProperty("permission")
    private PermissionModel permission;

    @JsonProperty("action")
    private ActionModel action;

    public static UserGroupModel getModelByUserGroup(UserGroup group) {
        UserGroupModel model = new UserGroupModel();
        PermissionModel permModel = new PermissionModel();
        ActionModel actModel = new ActionModel();

        model.setName(group.getName());
        model.setDescription(group.getDescription());

        Permission permission = group.getPermission();

        permModel.setCode(permission.getCode());
        permModel.setDescription(permission.getDescription());
        permModel.setViewChallenges(permission.getViewChallenges());
        permModel.setViewRanking(permission.getViewRanking());
        permModel.setViewReports(permission.getViewReports());
        permModel.setViewConfig(permission.getViewConfig());

        Action action = group.getAction();

        actModel.setConfChallenges(action.getConfChallenges());
        actModel.setPlayChallenges(action.getPlayChallenges());
        actModel.setConfUsers(action.getConfUsers());
        actModel.setViewUsers(action.getViewUsers());
        actModel.setConfGroups(action.getConfGroups());
        actModel.setViewGroups(action.getViewGroups());

        model.setPermission(permModel);
        model.setAction(actModel);

        return model;
    }

}
