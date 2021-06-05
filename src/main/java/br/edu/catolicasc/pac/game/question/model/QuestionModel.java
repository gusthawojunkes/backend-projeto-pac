package br.edu.catolicasc.pac.game.question.model;

import br.edu.catolicasc.pac.game.alternatives.Alternative;
import br.edu.catolicasc.pac.game.level.Level;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class QuestionModel {

    private String title;

    private String description;

    private Level level;

//    private User owner;

    private char correctResponse;

    private List<Alternative> alternatives;

    private Integer points;

}
