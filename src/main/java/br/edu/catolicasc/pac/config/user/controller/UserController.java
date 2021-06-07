package br.edu.catolicasc.pac.config.user.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/users")
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
    public User create(@RequestBody User user) {
        return repo.save(user);
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
}
