package br.edu.catolicasc.pac.login.controller.model;

import br.edu.catolicasc.utils.Utils;
import lombok.Getter;

@Getter
public class LoginModel {

    private String login;
    private String password;
    private String token;

    public Boolean isValid() {
        if (Utils.isEmpty(this.login) || Utils.isEmpty(this.password) || Utils.isEmpty(this.token)) return false;
        return true;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
    public String getToken() {
        return token;
    }

}
