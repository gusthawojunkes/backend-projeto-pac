package br.edu.catolicasc.utils;

import br.edu.catolicasc.pac.repository.utils.AbstractRepository;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Getter
@Setter
@EqualsAndHashCode
public abstract class AbstractController {

    private final AbstractRepository repo;

    protected AbstractController(AbstractRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/create")
    protected void create(@RequestBody Class<?> clazz) {
        
    }

    @GetMapping
    protected Iterable<Class<?>> read() {
        return null;
    }

    @PostMapping("/update")
    protected void update(@RequestBody Class<?> clazz) {

    }

    @DeleteMapping("/delete")
    protected ResponseEntity<?> delete() {
        return null;
    }

}
