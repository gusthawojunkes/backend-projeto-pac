package br.edu.catolicasc.pac.config.user.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.config.user.model.UserModel;
import br.edu.catolicasc.pac.game.ranking.Ranking;
import br.edu.catolicasc.pac.repository.config.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository repo;

    @Autowired
    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<User> findAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<User> user = repo.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/create")
    public User create(@RequestBody UserModel model) throws ParseException {
        return repo.save(new User(model));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody User user) {
        if (user == null) return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
        return repo.findById(user.getId()).map(record -> {
            record.setFields(user);
            User updated = repo.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping(path ={"/delete/{id}"})
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return repo.findById(id).map(record -> {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping(path = "/name/{userName}")
    public ResponseEntity<?> findByUserName(@PathVariable("userName") String userName) {
        User user = repo.findByUserName(userName);
        if (user == null) return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/ranking")
    public List<Ranking> getRanking() {
        List<Ranking> listReturn = new ArrayList<>();
        List<User> users = (List<User>) repo.findAll();
        AtomicInteger count = new AtomicInteger(1);
        users.stream()
             .filter(user -> user.getPoints() != null)
             .sorted(Comparator.comparing(User::getPoints).reversed())
             .forEach(user -> {
                 Ranking record = new Ranking(count.getAndIncrement(), user.getName(), user.getPoints());
                 listReturn.add(record);
             });
        return listReturn;
    }

}
