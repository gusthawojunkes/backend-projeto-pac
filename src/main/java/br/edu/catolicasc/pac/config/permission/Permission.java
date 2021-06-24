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
        this.viewChallenges = model.getViewChallenges() != null && model.getViewChallenges() ? 1 : 0;
        this.viewRanking = model.getViewRanking() != null && model.getViewRanking() ? 1 : 0;
        this.viewReports = model.getViewReports() != null && model.getViewReports() ? 1 : 0;
        this.viewConfig = model.getViewConfig() != null && model.getViewConfig() ? 1 : 0;
    }

    @Column(length = 1)
    private Integer viewChallenges;

    @Column(length = 1)
    private Integer viewRanking;

    @Column(length = 1)
    private Integer viewReports;

    @Column(length = 1)
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
