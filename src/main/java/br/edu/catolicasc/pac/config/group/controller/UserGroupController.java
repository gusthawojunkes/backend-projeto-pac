package br.edu.catolicasc.pac.config.group.controller;

import br.edu.catolicasc.pac.repository.config.UserGroupRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/groups")
public class UserGroupController {

    private final UserGroupRepository repo;

    public UserGroupController(UserGroupRepository repo) {
        this.repo = repo;
    }
}
