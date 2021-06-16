package br.edu.catolicasc.pac.config.group.model;

import br.edu.catolicasc.pac.config.action.model.ActionModel;
import br.edu.catolicasc.pac.config.permission.model.PermissionModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGroupModel {

    private String name;

    private String description;

    private PermissionModel permission;

    private ActionModel action;

}
