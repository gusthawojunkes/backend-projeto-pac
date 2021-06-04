package br.edu.catolicasc.pac.game.question.model;

import br.edu.catolicasc.pac.game.alternatives.Alternative;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
public class QuestionModel {

    private String title;

    private String description;

    private String level;

    private String ownerName;

    private char correctResponse;

    private Collection<Alternative> alternatives;

    private Integer points;

}
