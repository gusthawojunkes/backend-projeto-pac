package br.edu.catolicasc.pac.config.uf.controller;

import br.edu.catolicasc.pac.config.uf.UF;
import br.edu.catolicasc.pac.repository.game.UFRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/ufs")
public class UFController {

    private final UFRepository repo;

    public UFController(UFRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<UF> findAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<UF> uf = repo.findById(id);
        return new ResponseEntity<>(uf, HttpStatus.OK);
    }

}
