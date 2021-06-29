package br.edu.catolicasc.pac.game.question.model;

import br.edu.catolicasc.pac.config.user.model.UserModel;
import br.edu.catolicasc.pac.game.alternative.Alternative;
import br.edu.catolicasc.pac.game.alternative.model.AlternativeModel;
import br.edu.catolicasc.pac.game.question.Question;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class QuestionModel {

    private Long id;

    private String title;

    private String description;

    private Integer level;

    private UserModel owner;

    private char correctResponse;

    @JsonProperty("alternatives")
    private List<AlternativeModel> alternatives;

}
