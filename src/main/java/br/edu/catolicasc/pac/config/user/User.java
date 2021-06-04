package br.edu.catolicasc.pac.config.user;

import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
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

    private Integer points;

    public void setFields(User user) {
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());
        this.setBirth(user.getBirth());
        this.setFone(user.getFone());
    }

    @PrePersist
    @PreUpdate
    private void validateEmail() throws Exception {
        String email = this.email;
        if (StringUtils.isBlank(email) || Utils.Email.isNotValid(email)) throw new Exception("Invalid e-mail");
    }

}
