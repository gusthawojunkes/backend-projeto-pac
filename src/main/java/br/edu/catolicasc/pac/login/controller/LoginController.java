package br.edu.catolicasc.pac.login.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @GetMapping("/{username}&{password}&{token}")
    public boolean login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("token") String token) {
        return authenticate(username, password, token);
    }

    private boolean authenticate(String username, String password, String token) {
        return false;
    }

}
