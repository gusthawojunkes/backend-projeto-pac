package br.edu.catolicasc.pac.config.action.model;

import br.edu.catolicasc.pac.config.action.Action;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class ActionModel {

    public ActionModel(Action action) {
        this.confChallenges = action.getConfChallenges();
        this.playChallenges = action.getPlayChallenges();
        this.confUsers = action.getConfUsers();
        this.viewUsers = action.getViewUsers();
        this.confGroups = action.getConfGroups();
        this.viewGroups = action.getViewGroups();
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
