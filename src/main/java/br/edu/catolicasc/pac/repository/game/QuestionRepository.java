package br.edu.catolicasc.pac.repository.game;

import br.edu.catolicasc.pac.game.question.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long> {

    @Query("SELECT q FROM Question q WHERE q.level = :p1")
    public List<Question> getQuestionByLevel(@Param("p1") Integer level);

    @Query("SELECT q FROM Question q WHERE q.level = :p1 AND q.owner = (SELECT u FROM User u WHERE :p2 IN (SELECT s.id FROM u.students s))")
    public List<Question> getQuestionByStudentAndLevel(@Param("p1") Integer level, @Param("p2") Long student);

}
