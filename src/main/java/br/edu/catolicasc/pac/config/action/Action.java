package br.edu.catolicasc.pac.config.action;


import br.edu.catolicasc.pac.config.action.model.ActionModel;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@NoArgsConstructor
@Setter
@Entity
public class Action extends AbstractEntity {

    public Action(ActionModel model) {
        this.confChallenges = model.getConfChallenges();
        this.playChallenges = model.getPlayChallenges();
        this.confUsers = model.getConfUsers();
        this.viewUsers = model.getViewUsers();
        this.confGroups = model.getConfGroups();
        this.viewGroups = model.getViewGroups();
    }

    private Integer confChallenges;

    private Integer playChallenges;

    private Integer confUsers;

    private Integer viewUsers;

    private Integer confGroups;

    private Integer viewGroups;

    public Integer getConfChallenges() {
        return confChallenges != null ? confChallenges : 0;
    }

    public Integer getPlayChallenges() {
        return playChallenges != null ? playChallenges : 0;
    }

    public Integer getConfUsers() {
        return confUsers != null ? confUsers : 0;
    }

    public Integer getViewUsers() {
        return viewUsers != null ? viewUsers : 0;
    }

    public Integer getConfGroups() {
        return confGroups != null ? confGroups : 0;
    }

    public Integer getViewGroups() {
        return viewGroups != null ? viewGroups : 0;
    }

}
