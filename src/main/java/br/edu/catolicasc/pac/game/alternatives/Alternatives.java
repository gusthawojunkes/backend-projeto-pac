package br.edu.catolicasc.pac.game.alternatives;

import javax.persistence.*;

@Entity
public class Alternatives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    //option enum(‘A’,’B’,’C’,’D’,’E’) NOT NULL

}
