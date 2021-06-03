package br.edu.catolicasc.pac.game.question;

import br.edu.catolicasc.pac.game.alternatives.Alternatives;

import javax.persistence.*;

@Entity
public class QuestionAlternatives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Question question;

    @ManyToOne
    private Alternatives alternatives;

}
