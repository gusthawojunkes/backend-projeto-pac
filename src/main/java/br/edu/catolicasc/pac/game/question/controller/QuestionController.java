package br.edu.catolicasc.pac.game.question.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.config.user.model.UserModel;
import br.edu.catolicasc.pac.game.question.Question;
import br.edu.catolicasc.pac.game.question.model.QuestionModel;
import br.edu.catolicasc.pac.repository.config.UserRepository;
import br.edu.catolicasc.pac.repository.game.QuestionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/questions")
public class QuestionController {

    private final QuestionRepository repo;
    private final UserRepository userRepo;

    public QuestionController(QuestionRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    @GetMapping
    public List<QuestionModel> findAll() {
        List<QuestionModel> listRet = new ArrayList<>();
        Iterable<Question> questions = repo.findAll();
        questions.forEach(question -> {
            listRet.add(Question.getModel(question));
        });
        return listRet;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Question> question = repo.findById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public ResponseEntity<?> create(@RequestBody QuestionModel model) {
        User user = null;
        UserModel owner = model.getOwner();
        if (owner != null && owner.getId() != null) {
            user = userRepo.findById(owner.getId()).orElse(null);
        }
        Question question = new Question(model);
        question.setOwner(user);
        repo.save(question);
        return new ResponseEntity<>("Saved successfully!", HttpStatus.OK);
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
            repo.delete(record);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/level/{level}")
    public List<QuestionModel> getQuestionsByLevel(@PathVariable("level") Integer level) {
        return getQuestionsByLevelAndStudent(level, null);
    }

    @GetMapping("/{student}/{level}")
    public List<QuestionModel> getQuestionsByLevelAndStudent(@PathVariable("level") Integer level, @PathVariable("student") Long studentId) {
        List<QuestionModel> listReturn = new ArrayList<>();
        List<Question> questions;

        if (studentId != null) {
            questions = repo.getQuestionByStudentAndLevel(level, studentId);
        } else {
            questions = repo.getQuestionByLevel(level);
        }
        Collections.shuffle(questions, new Random(5));

        questions.stream().limit(5).forEach(question -> {
            listReturn.add(Question.getModel(question));
        });

        return listReturn;
    }
}
