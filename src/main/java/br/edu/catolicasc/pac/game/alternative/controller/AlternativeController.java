package br.edu.catolicasc.pac.game.alternative.controller;

import br.edu.catolicasc.pac.game.alternative.Alternative;
import br.edu.catolicasc.pac.game.alternative.model.AlternativeModel;
import br.edu.catolicasc.pac.repository.game.AlternativeRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path = "/alternatives")
public class AlternativeController {

    private final AlternativeRepository repo;

    public AlternativeController(AlternativeRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Alternative> findAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Alternative> alternative = repo.findById(id);
        return new ResponseEntity<>(alternative, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = "application/json")
    public Alternative create(@RequestBody AlternativeModel model) {
        return repo.save(new Alternative(model));
    }

    public Alternative getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}
