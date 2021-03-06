package br.edu.catolicasc.pac.game.alternative;

import br.edu.catolicasc.pac.game.alternative.model.AlternativeModel;
import br.edu.catolicasc.pac.game.question.Question;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}
