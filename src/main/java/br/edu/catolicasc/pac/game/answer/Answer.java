package br.edu.catolicasc.pac.game.answer;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.game.question.Question;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Answer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Question question;

    //answer enum(‘A’, ‘B’, ‘C’, ‘D’, ‘E’) -> questionAlternative

    @OneToOne
    private User student;

    @CreationTimestamp
    private LocalDateTime answeredAt;

    private Integer points;

}
