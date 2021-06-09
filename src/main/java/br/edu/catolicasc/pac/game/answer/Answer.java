package br.edu.catolicasc.pac.game.answer;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.game.question.Question;
import br.edu.catolicasc.utils.AbstractEntity;

import javax.persistence.*;

@Entity
public class Answer extends AbstractEntity {

    @OneToOne
    private Question question;

    @Column(nullable = false, length = 1)
    private char answer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private User student;

}
