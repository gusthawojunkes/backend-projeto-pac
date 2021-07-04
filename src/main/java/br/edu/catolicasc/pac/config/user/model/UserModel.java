package br.edu.catolicasc.pac.config.user.model;

import br.edu.catolicasc.pac.config.action.Action;
import br.edu.catolicasc.pac.config.action.model.ActionModel;
import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.address.model.AddressModel;
import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.pac.config.group.model.UserGroupModel;
import br.edu.catolicasc.pac.config.permission.Permission;
import br.edu.catolicasc.pac.config.permission.model.PermissionModel;
import br.edu.catolicasc.pac.config.school.School;
import br.edu.catolicasc.pac.config.school.model.SchoolModel;
import br.edu.catolicasc.pac.config.uf.UF;
import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.game.question.model.QuestionModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

@Getter
@Setter
public class UserModel {

    private Long id;

    private String name;

    private String email;

    private String userName;

    private String password;

    private String birth;

    private String phone;

    private Integer flagMaster;

    private Integer extraTime;

    private String userToken;

    @JsonProperty("address")
    private AddressModel address;

    @JsonProperty("group")
    private UserGroupModel group;

    private Integer points;

    @JsonProperty("questions")
    private List<QuestionModel> questions;

    @JsonProperty("school")
    private SchoolModel school;

    public static UserModel getModelFromUser(User user) {
        UserModel model = new UserModel();
        model.setId(user.getId());
        model.setName(user.getName());
        model.setBirth(User.SDF.format(user.getBirth()));
        model.setFlagMaster(user.getFlagMaster());
        model.setExtraTime(user.getExtraTime());
        model.setPoints(user.getPoints());
        model.setPhone(user.getPhone());
        model.setEmail(user.getEmail());
        model.setGroup(user.getGroup());
        model.setAddress(user.getAddress());
        model.setSchool(user.getSchool());
        return model;
    }

    public void setAddress(Address address) {
        AddressModel model = this.address;
        if(model == null) return;
        UF uf = address.getUf();
        model.setCity(StringUtils.isNotBlank(address.getCity()) ? address.getCity() : "");
        if (uf != null) {
            model.setUf(StringUtils.isNotBlank(uf.getUf()) ? uf.getUf() : "");
            model.setUfName(StringUtils.isNotBlank(uf.getName()) ? uf.getName() : "");
        }
        this.address = model;
    }

    public void setGroup(UserGroup group) {
        if (group == null) return;
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
        this.group = model;
    }

    public void setSchool(School school) {
        if (school == null) return;
        this.school = new SchoolModel(school);
    }
}
