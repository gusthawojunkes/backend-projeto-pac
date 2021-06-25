package br.edu.catolicasc.pac.config.group.controller;

import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.pac.config.group.model.UserGroupModel;
import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.repository.config.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/groups")
public class UserGroupController {

    private final UserGroupRepository repo;

    @Autowired
    public UserGroupController(UserGroupRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<UserGroupModel> findAll() {
        List<UserGroupModel> listReturn = new ArrayList<>();
        Iterable<UserGroup> groups = repo.findAll();
        for(UserGroup group : groups) {
            UserGroupModel model = UserGroupModel.getModelByUserGroup(group);
            listReturn.add(model);
        }
        return listReturn;
    }

    @PostMapping("/create")
    public UserGroup create(@RequestBody UserGroupModel model) throws ParseException {
        return repo.save(new UserGroup(model));
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody UserGroupModel group) {
        if (group == null) return new ResponseEntity<>("Group not found", HttpStatus.NO_CONTENT);
        return repo.findById(group.getId()).map(record -> {
            UserGroup updated = repo.save(record);
            return ResponseEntity.ok().body(updated);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return repo.findById(id).map(record -> {
            repo.deleteById(id);
            return ResponseEntity.ok().build();
        }).orElse(ResponseEntity.notFound().build());
    }
}
