package br.edu.catolicasc.pac.game.answer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AnswerModel {

    private Long questionId;

    private String studentName;

    private char answer;

}
