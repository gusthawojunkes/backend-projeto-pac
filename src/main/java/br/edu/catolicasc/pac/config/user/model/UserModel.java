package br.edu.catolicasc.pac.config.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserModel {

    private String name;

    private String email;

    private String userName;

    private String password;

    private String birth;

    private String fone;

    private Integer flagMaster;

    private Integer extraTime;

    private String userToken;

    private Long addressId;

    private Long groupId;

    private Integer points;

    private Long answerId;

}
