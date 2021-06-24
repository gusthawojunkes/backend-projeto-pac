package br.edu.catolicasc.pac.config.permission.model;

import br.edu.catolicasc.pac.config.permission.Permission;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PermissionModel {

    public PermissionModel(Permission permission) {
        this.viewChallenges = permission.getViewChallenges() != null && permission.getViewChallenges() == 1;
        this.viewRanking = permission.getViewRanking() != null && permission.getViewRanking() == 1;
        this.viewReports = permission.getViewReports() != null && permission.getViewReports() == 1;
        this.viewConfig = permission.getViewConfig() != null && permission.getViewConfig() == 1;
    }

    private Boolean viewChallenges;

    private Boolean viewRanking;

    private Boolean viewReports;

    private Boolean viewConfig;

    public Boolean getViewChallenges() {
        return viewChallenges != null ? viewChallenges : false;
    }

    public Boolean getViewRanking() {
        return viewRanking != null ? viewRanking : false;
    }

    public  Boolean getViewReports() {
        return  viewReports != null ? viewReports : false;
    }

    public Boolean getViewConfig() {
        return viewConfig != null ? viewConfig : false;
    }
}
