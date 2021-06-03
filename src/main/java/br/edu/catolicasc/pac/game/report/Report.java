package br.edu.catolicasc.pac.game.report;

import br.edu.catolicasc.pac.config.user.User;

import javax.persistence.*;

@Entity
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User student;

    private Integer points;
}
