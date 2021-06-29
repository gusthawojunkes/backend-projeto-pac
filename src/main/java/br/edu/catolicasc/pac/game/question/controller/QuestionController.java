package br.edu.catolicasc.pac.game.question.controller;

import br.edu.catolicasc.pac.game.question.Question;
import br.edu.catolicasc.pac.game.question.model.QuestionModel;
import br.edu.catolicasc.pac.repository.game.QuestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository repo;

    public QuestionController(QuestionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<QuestionModel> findAll() {
        List<QuestionModel> listRet = new ArrayList<>();
        Iterable<Question> questions = repo.findAll();
        for (Question question : questions) {
            listRet.add(Question.getModel(question));
        }
        return listRet;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Question> question = repo.findById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public Question create(@RequestBody QuestionModel model) throws ParseException {
        return repo.save(new Question(model));
    }

    public Question getById(Long id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody QuestionModel question) {
        if (question == null) return new ResponseEntity<>("Question not found", HttpStatus.NO_CONTENT);
        return repo.findById(question.getId()).map(record -> {
            Question updated = repo.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return repo.findById(id).map(record -> {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/level/{level}")
    public List<QuestionModel> getQuestionsByLevel(@PathVariable("level") Integer level) {
        List<QuestionModel> listReturn = new ArrayList<QuestionModel>();
        Iterable<Question> questions = repo.getQuestionByLevel(level);
        for (Question question : questions) {
            listReturn.add(Question.getModel(question));
        }
        return listReturn;
    }
}
