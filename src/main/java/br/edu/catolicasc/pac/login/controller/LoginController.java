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

    private final UserRepository userDAO;
    private User userLogin;

    public LoginController(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity<?> login(LoginModel login) {
        Boolean authenticated = authenticate(login);
        if (!authenticated) return new ResponseEntity<>(false, HttpStatus.UNAUTHORIZED);
        return new ResponseEntity<>(UserModel.getModelFromUser(this.userLogin), HttpStatus.OK);
    }

    private Boolean authenticate(LoginModel model) {
        if (model == null) return false;

        log(model);

        if (!model.isValid()) return false;

        String userName = model.getLogin();
        this.userLogin = userDAO.findByUserName(userName);

        if (userLogin == null) return false;

        //TODO implementação do TOKEN fica para depois
        //if (Utils.isEmpty(userLogin.getUserToken())) return false;

        //String token = model.getToken();
        String password = model.getPassword();
        return userLogin.getPassword().equals(password);
        //return userLogin.getPassword().equals(password) && userLogin.getUserToken().equals(token);

    }

    public void log(LoginModel model) {
        System.out.println("Validating >>> [" + model.getLogin() + " - " + model.getPassword() + " - " + model.getToken() + "]");
    }

}
