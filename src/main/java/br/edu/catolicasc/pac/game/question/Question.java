package br.edu.catolicasc.pac.game.question;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.game.alternative.Alternative;
import br.edu.catolicasc.pac.game.alternative.model.AlternativeModel;
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
        this.owner = model.getOwner();
        this.correctResponse = model.getCorrectResponse();
        this.alternatives = getListFromModel(model.getAlternatives());
    }

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String description;

    @Column(length = 1)
    private Integer level;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User owner;

    @Column(nullable = false, length = 1)
    private char correctResponse;

    @Column(nullable = false)
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "question_id")
    private List<Alternative> alternatives;

    private List<Alternative> getListFromModel(List<AlternativeModel> listModel) {
        List<Alternative> listReturn = new ArrayList<Alternative>();

        for(AlternativeModel alternative : listModel) {
            Alternative newAlternative = new Alternative(alternative);
            listReturn.add(newAlternative);
        }

        return listReturn;
    }

    public static QuestionModel getModel(Question question) {
        List<AlternativeModel> listAlternatives = new ArrayList<>();
        QuestionModel model = new QuestionModel();
        model.setId(question.getId());
        model.setTitle(question.getTitle());
        model.setDescription(question.getDescription());
        model.setLevel(question.getLevel());
        model.setCorrectResponse(question.getCorrectResponse());
        for (Alternative alternative : question.getAlternatives()) {
            listAlternatives.add(new AlternativeModel(alternative));
        }
        model.setAlternatives(listAlternatives);
        return model;
    }

}
