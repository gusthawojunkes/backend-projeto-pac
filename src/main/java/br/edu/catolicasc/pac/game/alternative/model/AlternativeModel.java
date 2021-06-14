package br.edu.catolicasc.pac.game.alternative.model;

import br.edu.catolicasc.pac.game.alternative.Alternative;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlternativeModel {

    public AlternativeModel(Alternative alternative) {
        this.option = alternative.getOption();
        this.description = alternative.getDescription();
    }

    private char option;

    private String description;

    //private Question question;

}
