package br.edu.catolicasc.pac.repository.game;

import br.edu.catolicasc.pac.game.question.Question;
import org.springframework.data.repository.CrudRepository;

public interface QuestionRepository extends CrudRepository<Question, Long> {
}
