package br.edu.catolicasc.pac.login.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.login.controller.model.LoginModel;
import br.edu.catolicasc.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<?> login(LoginModel model) {
        Boolean authenticated = authenticate(username, password, token);
        HttpStatus statusCode = authenticated ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(authenticated, statusCode);
    }

    private Boolean authenticate(LoginModel model) {
        if (model == null) return false;
        String login = model.getLogin();
        String password = model.getPassword();
        String token = model.getToken();
        System.out.println("Validating >>> [" + login + " - " + password + " - " + token + "]");
        User userLogin = User.findByUserName(login);
        if (userLogin == null) return false;
        return Utils.isNotEmpty(userLogin.getPassword())
            && userLogin.getPassword().equals(password)
            && Utils.isNotEmpty(userLogin.getUserToken())
            && userLogin.getUserToken().equals(token);
    }

}
