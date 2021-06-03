package br.edu.catolicasc.pac.game.level;

import javax.persistence.*;

@Entity
public class Level {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String title;

    @Column
    private String description;

}
