package br.edu.catolicasc.pac.game.question.controller;

import br.edu.catolicasc.pac.game.question.Question;
import br.edu.catolicasc.pac.game.question.model.QuestionModel;
import br.edu.catolicasc.pac.repository.game.QuestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository repo;

    public QuestionController(QuestionRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Question> findAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Question> question = repo.findById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public Question create(@RequestBody QuestionModel model) {
        return repo.save(new Question(model));
    }

    public Question getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
