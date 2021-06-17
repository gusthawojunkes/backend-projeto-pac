package br.edu.catolicasc.pac.config.permission;

import br.edu.catolicasc.pac.config.permission.model.PermissionModel;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@NoArgsConstructor
@Getter
@Setter
@Entity
public class Permission extends AbstractEntity {

    public Permission(PermissionModel model) {
        this.code = model.getCode();
        this.description = model.getDescription();
        this.viewChallenges = model.getViewChallenges();
        this.viewRanking = model.getViewRanking();
        this.viewReports = model.getViewReports();
        this.viewConfig = model.getViewConfig();
    }

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
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
