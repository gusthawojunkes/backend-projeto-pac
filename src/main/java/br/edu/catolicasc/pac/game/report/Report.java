package br.edu.catolicasc.pac.game.report;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.game.question.Question;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Report extends AbstractEntity {

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_user_id")
    private User student;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "report_id")
    private Question question;

    @Column(nullable = false, length = 1)
    private char response;

}
