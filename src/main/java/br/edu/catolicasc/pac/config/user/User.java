package br.edu.catolicasc.pac.config.user;

import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class User extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    private Date birth;

    private String fone;

    private Integer flagMaster;

    private Integer extraTime;

    private String userToken;

    //Address

    //Group

    public static User findByUserName(String userName) {
        return null;
    }

}
