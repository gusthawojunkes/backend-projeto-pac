package br.edu.catolicasc.pac.config.group.controller;

import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.pac.config.group.model.UserGroupModel;
import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.config.user.model.UserModel;
import br.edu.catolicasc.pac.repository.config.UserGroupRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/groups")
public class UserGroupController {

    private final UserGroupRepository repo;

    public UserGroupController(UserGroupRepository repo) {
        this.repo = repo;
    }

    @PostMapping("/create")
    public UserGroup create(@RequestBody UserGroupModel model) throws ParseException {
        return repo.save(new UserGroup(model));
    }
}
