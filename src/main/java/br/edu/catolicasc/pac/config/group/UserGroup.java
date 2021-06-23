package br.edu.catolicasc.pac.config.group;

import br.edu.catolicasc.pac.config.action.Action;
import br.edu.catolicasc.pac.config.group.model.UserGroupModel;
import br.edu.catolicasc.pac.config.permission.Permission;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class UserGroup extends AbstractEntity {

    public UserGroup(UserGroupModel model) {
        this.name = model.getName();
        this.description = model.getDescription();
        this.permission = new Permission(model.getPermission());
        this.action = new Action(model.getAction());
    }

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 100)
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    private Permission permission;

    @OneToOne(cascade = CascadeType.ALL)
    private Action action;

}
