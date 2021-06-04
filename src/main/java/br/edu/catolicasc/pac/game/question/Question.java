package br.edu.catolicasc.pac.game.question;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.game.alternatives.Alternative;
import br.edu.catolicasc.pac.game.level.Level;
import br.edu.catolicasc.pac.game.question.model.QuestionModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question {

    public Question(QuestionModel model) {
        this.title = model.getTitle();
        this.description = model.getDescription();
        //this.level = model.getLevel();
        //this.owner = model.getOwnerName();
        this.correctResponse = model.getCorrectResponse();
        this.alternatives = model.getAlternatives();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String description;

    @ManyToOne
    private Level level;

    @ManyToOne
    private User owner;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(nullable = false, length = 1)
    private char correctResponse;

    @OneToMany(orphanRemoval = true)
    private Collection<Alternative> alternatives;

    private Integer points;

}
