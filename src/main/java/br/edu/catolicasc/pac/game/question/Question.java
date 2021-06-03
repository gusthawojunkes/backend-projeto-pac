package br.edu.catolicasc.pac.game.question;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.game.level.Level;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String description;

//    @OneToMany
//    private Level level;

    @ManyToOne
    private User owner;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    //correct_response enum(‘A’, ‘B’, ‘C’, ‘D’, ‘E’)

}
