package br.edu.catolicasc.pac.game.answer;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.game.question.Question;

import javax.persistence.*;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Question question;

    @Column(nullable = false, length = 1)
    private char answer;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "answer")
    private User students;

}
