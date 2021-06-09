package br.edu.catolicasc.pac.game.alternatives;

import br.edu.catolicasc.utils.AbstractEntity;

import javax.persistence.*;

@Entity
public class Alternative extends AbstractEntity {

    @Column(nullable = false, length = 1)
    private char option;

    @Column(nullable = false)
    private String description;

}
