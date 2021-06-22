package br.edu.catolicasc.pac.config.action;


import br.edu.catolicasc.pac.config.action.model.ActionModel;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
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

    @Column(length = 1)
    private Integer confChallenges;

    @Column(length = 1)
    private Integer playChallenges;

    @Column(length = 1)
    private Integer confUsers;

    @Column(length = 1)
    private Integer viewUsers;

    @Column(length = 1)
    private Integer confGroups;

    @Column(length = 1)
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
