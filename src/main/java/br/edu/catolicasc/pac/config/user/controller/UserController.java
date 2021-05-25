package br.edu.catolicasc.pac.config.user.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {

    private final UserRepository userDAO;

    @Autowired
    public UserController(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        return new ResponseEntity<>(userDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<?> findByName(@PathVariable("name") String name) {
        User user = userDAO.findByUserName(name);
        if (user == null) return new ResponseEntity<>("User not found", HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        userDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User user) {
        userDAO.save(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
