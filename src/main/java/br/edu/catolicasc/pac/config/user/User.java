package br.edu.catolicasc.pac.config.user;

import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.pac.config.user.model.UserModel;
import br.edu.catolicasc.pac.game.answer.Answer;
import br.edu.catolicasc.utils.AbstractEntity;
import br.edu.catolicasc.utils.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class User extends AbstractEntity {

    private static final SimpleDateFormat SDF = new SimpleDateFormat("dd/MM/yyyy");

    public User(UserModel model) throws ParseException {
        this.name = model.getName();
        this.email = model.getEmail();
        this.userName = model.getUserName();
        this.password = model.getPassword();
        this.fone = model.getFone();
        this.flagMaster = model.getFlagMaster();
        this.extraTime = model.getExtraTime();
        this.userToken = model.getUserToken();
        this.points = model.getPoints();
        this.birth = SDF.parse(model.getBirth());
    }

    @Column(nullable = false, length = 70)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false, length = 50)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;

    @Column(length = 20)
    private String fone;

    @Column(length = 1)
    private Integer flagMaster;

    private Integer extraTime;

    private String userToken;

    @OneToOne
    private Address address;

    @OneToOne
    private UserGroup group;

    @Column(length = 3)
    private Integer points;

//    @OneToOne
//    private Answer answer;

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
