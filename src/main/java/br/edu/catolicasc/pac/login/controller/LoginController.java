package br.edu.catolicasc.pac.login.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.utils.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @GetMapping("/{username}&{password}&{token}")
    public ResponseEntity<?> login(@PathVariable("username") String username, @PathVariable("password") String password, @PathVariable("token") String token) {
        Boolean authenticated = authenticate(username, password, token);
        HttpStatus statusCode = authenticated ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(authenticated, statusCode);

    }

    private Boolean authenticate(String username, String password, String token) {
        System.out.println("Validating >>> [" + username + " - " + password + " - " + token + "]");
        User userLogin = User.findByName(username);
        if (userLogin == null) return false;
        if (StringUtils.isNotBlank(userLogin.getPassword())
            && userLogin.getPassword().equals(password)
            && StringUtils.isNotBlank(userLogin.getUserToken())
            && userLogin.getUserToken().equals(token))
        {
            return true;
        }
        return null;
    }

}
