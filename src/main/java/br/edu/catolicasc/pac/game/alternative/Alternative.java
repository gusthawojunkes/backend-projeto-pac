package br.edu.catolicasc.pac.game.alternative;

import br.edu.catolicasc.pac.game.alternative.model.AlternativeModel;
import br.edu.catolicasc.pac.game.question.Question;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Alternative extends AbstractEntity {

    public Alternative(AlternativeModel model) {
        this.option = model.getOption();
        this.description = model.getDescription();
    }

    @Column(nullable = false, length = 1)
    private char option;

    @Column(nullable = false)
    private String description;

    //TODO Revisar isso
    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}
