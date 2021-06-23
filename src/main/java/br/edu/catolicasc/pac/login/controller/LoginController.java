package br.edu.catolicasc.pac.login.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.config.user.model.UserModel;
import br.edu.catolicasc.pac.login.model.LoginModel;
import br.edu.catolicasc.pac.repository.config.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/login")
public class LoginController {

    /*
    * Esse bloco não deveria estar aqui segundo a arquitetura, mas por enquanto vou deixar aqui
    * para trabalhar com o dado do login
    * */

    private final UserRepository userDAO;
    private User userLogin;

    public LoginController(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    //Até aqui

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity<?> login(LoginModel login) {
        Boolean authenticated = authenticate(login);
        if (!authenticated) return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        UserModel user = new UserModel();
        user.setUserName("root");
        user.setPassword("root");
        user.setName("Root");
        user.setEmail("root@system.com");
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    private Boolean authenticate(LoginModel model) {
        return true;
    }

    public void log(LoginModel model) {
        System.out.println("Validating >>> [" + model.getLogin() + " - " + model.getPassword() + " - " + model.getToken() + "]");
    }

}
