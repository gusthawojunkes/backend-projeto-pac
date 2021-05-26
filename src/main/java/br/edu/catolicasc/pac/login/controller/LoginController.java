package br.edu.catolicasc.pac.login.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.login.controller.model.LoginModel;
import br.edu.catolicasc.utils.Utils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginModel model) {
        Boolean authenticated = authenticate(model);
        HttpStatus statusCode = authenticated ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(authenticated, statusCode);
    }

    private Boolean authenticate(LoginModel model) {
        if (model == null) return false;

        log(model);

        String login = model.getLogin();
        User userLogin = User.findByUserName(login);

        if (userLogin == null) return false;

        String password = model.getPassword();
        String token = model.getToken();

        return Utils.isNotEmpty(userLogin.getPassword())
            && userLogin.getPassword().equals(password)
            && Utils.isNotEmpty(userLogin.getUserToken())
            && userLogin.getUserToken().equals(token);
    }

    public void log(LoginModel model) {
        System.out.println("Validating >>> [" + model.getLogin() + " - " + model.getPassword() + " - " + model.getToken() + "]");
    }

}
