package br.edu.catolicasc.pac.game.level;

import br.edu.catolicasc.utils.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Level extends AbstractEntity {

    @Column(nullable = false, length = 100)
    private char title;

    private String description;

    private Integer points;

}
