package br.edu.catolicasc.pac.config.user.controller;

import br.edu.catolicasc.pac.config.user.Ranking;
import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.config.user.model.UserModel;
import br.edu.catolicasc.pac.repository.config.UserGroupRepository;
import br.edu.catolicasc.pac.repository.config.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
    private final UserGroupRepository groupRepo;

    @Autowired
    public UserController(UserRepository repo, UserGroupRepository groupRepo) {
        this.repo = repo;
        this.groupRepo = groupRepo;
    }

    @GetMapping
    public List<UserModel> findAll() {
        List<UserModel> listReturn = new ArrayList<>();
        Iterable<User> users = repo.findAll();
        users.forEach(user -> {
           listReturn.add(UserModel.getModelFromUser(user));
        });
        return listReturn;
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<User> user = repo.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE })
    public User create(UserModel model) throws ParseException {
        User user = new User(model);
        if (model.getGroup() != null) {
            user.setGroup(groupRepo.findById(model.getGroup().getId()).orElse(null));
        }
        return repo.save(user);
    }

    //TODO Verficar se acontece o merge ou o persist para não acontecer erro de constraint
    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserModel model) throws ParseException {
        if (model == null) return new ResponseEntity<>("Model is Empty", HttpStatus.NO_CONTENT);
        User updated = new User(model);
        repo.save(updated);
        return new ResponseEntity<>("Updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
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
