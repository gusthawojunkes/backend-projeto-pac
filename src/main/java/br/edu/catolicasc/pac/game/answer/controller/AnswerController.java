package br.edu.catolicasc.pac.game.answer.controller;

import br.edu.catolicasc.pac.game.answer.model.AnswerModel;
import br.edu.catolicasc.pac.game.question.Question;
import br.edu.catolicasc.pac.game.question.controller.QuestionController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/answers")
public class AnswerController {

    private final QuestionController questionDAO;

    public AnswerController(QuestionController questionDAO) {
        this.questionDAO = questionDAO;
    }

    @PostMapping
    public Boolean correctAnswer(@RequestBody AnswerModel answer) {
        char selectedAlternative = answer.getAnswer();
        Question question = questionDAO.getById(answer.getQuestionId());
        return question.getCorrectResponse() == selectedAlternative;
    }

}
