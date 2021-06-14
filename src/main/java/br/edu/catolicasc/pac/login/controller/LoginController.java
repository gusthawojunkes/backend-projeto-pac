package br.edu.catolicasc.pac.login.controller;

import br.edu.catolicasc.pac.config.user.User;
import br.edu.catolicasc.pac.login.controller.model.LoginModel;
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

    public LoginController(UserRepository userDAO) {
        this.userDAO = userDAO;
    }

    //Até aqui

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping
    public ResponseEntity<?> login(LoginModel login) {
        Boolean authenticated = authenticate(login);
        HttpStatus statusCode = authenticated ? HttpStatus.OK : HttpStatus.UNAUTHORIZED;
        return new ResponseEntity<>(authenticated, statusCode);
    }

    private Boolean authenticate(LoginModel model) {
        if (model == null) return false;

        log(model);

        if (!model.isValid()) return false;

        String userName = model.getLogin();
        User userLogin = userDAO.findByUserName(userName);

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
