package br.edu.catolicasc.pac.config.group.controller;

import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.pac.config.group.model.UserGroupModel;
import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.config.user.model.UserModel;
import br.edu.catolicasc.pac.repository.config.UserGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
