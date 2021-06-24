package br.edu.catolicasc.pac.config.group.model;

import br.edu.catolicasc.pac.config.action.Action;
import br.edu.catolicasc.pac.config.action.model.ActionModel;
import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.pac.config.permission.Permission;
import br.edu.catolicasc.pac.config.permission.model.PermissionModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGroupModel {

    private Long id;

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

        model.setId(group.getId());
        model.setName(group.getName());
        model.setDescription(group.getDescription());

        Permission permission = group.getPermission();

        permModel.setViewChallenges(permission.getViewChallenges() == 1);
        permModel.setViewRanking(permission.getViewRanking() == 1);
        permModel.setViewReports(permission.getViewReports() == 1);
        permModel.setViewConfig(permission.getViewConfig() == 1);

        Action action = group.getAction();

        actModel.setConfChallenges(action.getConfChallenges() == 1);
        actModel.setPlayChallenges(action.getPlayChallenges() == 1);
        actModel.setConfUsers(action.getConfUsers() == 1);
        actModel.setViewUsers(action.getViewUsers() == 1);
        actModel.setConfGroups(action.getConfGroups() == 1);
        actModel.setViewGroups(action.getViewGroups() == 1);

        model.setPermission(permModel);
        model.setAction(actModel);

        return model;
    }

}
