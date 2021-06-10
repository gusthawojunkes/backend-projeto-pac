package br.edu.catolicasc.pac.game.alternative;

import br.edu.catolicasc.pac.game.question.Question;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Alternative extends AbstractEntity {

    @Column(nullable = false, length = 1)
    private char option;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

}
