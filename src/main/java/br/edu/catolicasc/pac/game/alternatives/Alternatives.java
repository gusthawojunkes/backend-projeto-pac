package br.edu.catolicasc.pac.game.alternatives;

import javax.persistence.*;

@Entity
public class Alternatives {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false, length = 1)
    private String option;

}
