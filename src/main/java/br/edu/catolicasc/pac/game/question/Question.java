package br.edu.catolicasc.pac.game.question;

import br.edu.catolicasc.pac.game.alternatives.Alternative;
import br.edu.catolicasc.pac.game.level.Level;
import br.edu.catolicasc.pac.game.question.model.QuestionModel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Question {

    public Question(QuestionModel model) {
        this.title = model.getTitle();
        this.description = model.getDescription();
        this.level = model.getLevel();
//        this.owner = model.getOwner();
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

    private Integer level;

//    @ManyToOne
//    private Level level;

//    @OneToOne
//    private User owner;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column(nullable = false, length = 1)
    private char correctResponse;

    //@Column(nullable = false)
    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    private List<Alternative> alternatives;

}
