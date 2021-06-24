package br.edu.catolicasc.pac.config.action.model;

import br.edu.catolicasc.pac.config.action.Action;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
public class ActionModel {

    public ActionModel(Action action) {
        this.confChallenges = action.getConfChallenges() != null && action.getConfChallenges() == 1;
        this.playChallenges = action.getPlayChallenges() != null && action.getPlayChallenges() == 1;
        this.confUsers = action.getConfUsers() != null && action.getConfUsers() == 1;
        this.viewUsers = action.getViewUsers() != null && action.getViewUsers() == 1;
        this.confGroups = action.getConfGroups() != null && action.getConfGroups() == 1;
        this.viewGroups = action.getViewGroups() != null && action.getViewGroups() == 1;
    }

    private Boolean confChallenges;

    private Boolean playChallenges;

    private Boolean confUsers;

    private Boolean viewUsers;

    private Boolean confGroups;

    private Boolean viewGroups;

    public Boolean getConfChallenges() {
        return confChallenges != null ? confChallenges : false;
    }

    public Boolean getPlayChallenges() {
        return playChallenges != null ? playChallenges : false;
    }

    public Boolean getConfUsers() {
        return confUsers != null ? confUsers : false;
    }

    public Boolean getViewUsers() {
        return viewUsers != null ? viewUsers : false;
    }

    public Boolean getConfGroups() {
        return confGroups != null ? confGroups : false;
    }

    public Boolean getViewGroups() {
        return viewGroups != null ? viewGroups : false;
    }
}
