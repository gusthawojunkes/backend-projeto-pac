package br.edu.catolicasc.pac.config.permission.model;

import br.edu.catolicasc.pac.config.permission.Permission;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PermissionModel {

    public PermissionModel(Permission permission) {
        this.code = permission.getCode();
        this.description = permission.getDescription();
        this.viewChallenges = permission.getViewChallenges();
        this.viewRanking = permission.getViewRanking();
        this.viewReports = permission.getViewReports();
        this.viewConfig = permission.getViewConfig();
    }

    private String code;

    private String description;

    private Integer viewChallenges;

    private Integer viewRanking;

    private Integer viewReports;

    private Integer viewConfig;

    public Integer getViewChallenges() {
        return viewChallenges != null ? viewChallenges : 0;
    }

    public Integer getViewRanking() {
        return viewRanking != null ? viewRanking : 0;
    }

    public  Integer getViewReports() {
        return  viewReports != null ? viewReports : 0;
    }

    public Integer getViewConfig() {
        return viewConfig != null ? viewConfig : 0;
    }
}
