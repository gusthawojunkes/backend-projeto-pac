package br.edu.catolicasc.pac.game.question;

import br.edu.catolicasc.pac.game.alternative.Alternative;
import br.edu.catolicasc.pac.game.question.model.QuestionModel;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question extends AbstractEntity {

    public Question(QuestionModel model) {
        this.title = model.getTitle();
        this.description = model.getDescription();
        this.level = model.getLevel();
//        this.owner = model.getOwner();
        this.correctResponse = model.getCorrectResponse();
        this.alternatives = model.getAlternatives();
    }

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String description;

    private Integer level;

//    @ManyToOne
//    private Level level;

//    @OneToOne
//    private User owner;

    @Column(nullable = false, length = 1)
    private char correctResponse;

    @Column(nullable = false)
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Alternative> alternatives;

}
