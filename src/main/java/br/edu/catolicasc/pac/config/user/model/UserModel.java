package br.edu.catolicasc.pac.config.user.model;

import br.edu.catolicasc.pac.config.action.Action;
import br.edu.catolicasc.pac.config.action.model.ActionModel;
import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.address.model.AddressModel;
import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.pac.config.group.model.UserGroupModel;
import br.edu.catolicasc.pac.config.permission.Permission;
import br.edu.catolicasc.pac.config.permission.model.PermissionModel;
import br.edu.catolicasc.pac.config.uf.UF;
import br.edu.catolicasc.pac.config.user.User;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class UserModel {

    private String name;

    private String email;

    private String userName;

    private String password;

    private String birth;

    private String phone;

    private Integer flagMaster;

    private Integer extraTime;

    private String userToken;

    private AddressModel address;

    private UserGroupModel group;

    private Integer points;

    public static UserModel getModelFromUser(User user) {
        UserModel model = new UserModel();
        model.setName(user.getName());
        model.setFlagMaster(user.getFlagMaster());
        model.setExtraTime(user.getExtraTime());
        model.setAddress(user.getAddress());
        model.setGroup(user.getGroup());
        model.setPoints(user.getPoints());
        return model;
    }

    private void setAddress(Address address) {
        AddressModel model = this.address;
        UF uf = address.getUf();
        model.setCity(StringUtils.isNotBlank(address.getCity()) ? address.getCity() : "");
        if (uf != null) {
            model.setUf(StringUtils.isNotBlank(uf.getUf()) ? uf.getUf() : "");
            model.setUfName(StringUtils.isNotBlank(uf.getName()) ? uf.getName() : "");
        }
    }

    private void setGroup(UserGroup group) {
        UserGroupModel model = new UserGroupModel();
        Permission permission = group.getPermission();
        Action action = group.getAction();
        model.setName(StringUtils.isNotBlank(group.getName()) ? group.getName() : "");
        model.setDescription(StringUtils.isNotBlank(group.getDescription()) ? group.getDescription() : "");
        if (permission != null) {
            PermissionModel permModel = new PermissionModel(permission);
            model.setPermission(permModel);
        }
        if (action != null) {
            ActionModel actModel = new ActionModel(action);
            model.setAction(actModel);
        }
    }
}
