package br.edu.catolicasc.pac.config.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Ranking {

    private Integer position;

    private String student;

    private Integer points;

}
