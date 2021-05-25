package br.edu.catolicasc.pac.config.user.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userDAO;

    @Autowired
    public UserController(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public Iterable<User> findAll() {
        return userDAO.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity findById(@PathVariable("id") Long id) {
        Optional<User> user = userDAO.findById(id);
        if (user == null) return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return userDAO.save(user);
    }

}
