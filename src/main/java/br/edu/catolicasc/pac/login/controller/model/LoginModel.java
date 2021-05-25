package br.edu.catolicasc.pac.login.controller.model;

import lombok.Getter;

@Getter
public class LoginModel {

    private String login;
    private String password;
    private String token;

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
