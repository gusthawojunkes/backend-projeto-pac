package br.edu.catolicasc.pac.login.model;

import br.edu.catolicasc.utils.Utils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginModel {

    private String login;
    private String password;
    private String token;

    public Boolean isValid() {
        //return !Utils.isEmpty(this.login) && !Utils.isEmpty(this.password) && !Utils.isEmpty(this.token);
        return !Utils.isEmpty(this.login) && !Utils.isEmpty(this.password);
    }
}
