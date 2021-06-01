package br.edu.catolicasc.pac.config.user;

import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.utils.AbstractEntity;
import br.edu.catolicasc.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
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

    @OneToOne
    private Address address;

    @OneToOne
    private UserGroup group;

    public static User findByUserName(String userName) {
        if (Utils.isNotEmpty(userName)) {

        }
        return null;
    }

    public String getPassword() {
        return password;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setFields(User user) {
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());
        this.setBirth(user.getBirth());
        this.setFone(user.getFone());
    }

}
