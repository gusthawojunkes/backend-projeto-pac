package br.edu.catolicasc.pac.config.address.controller;


import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.uf.UF;
import br.edu.catolicasc.pac.repository.game.AddressRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/addresses")
public class AddressController {

    private final AddressRepository repo;

    public AddressController(AddressRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Address> findAll() {
        return repo.findAll();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") Long id) {
        Optional<Address> address = repo.findById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

}
