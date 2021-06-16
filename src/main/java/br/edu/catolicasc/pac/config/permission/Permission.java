package br.edu.catolicasc.pac.config.permission;

import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Permission extends AbstractEntity {

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
