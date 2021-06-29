package br.edu.catolicasc.pac.config.user;

import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.group.UserGroup;
import br.edu.catolicasc.pac.config.user.model.UserModel;
import br.edu.catolicasc.pac.game.question.Question;
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
import java.util.List;

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
        this.phone = model.getPhone();
        this.flagMaster = model.getFlagMaster();
        this.extraTime = model.getExtraTime();
        this.userToken = model.getUserToken();
        this.points = model.getPoints() != null ? model.getPoints() : 0;
        this.birth = SDF.parse(model.getBirth());
        if (model.getQuestions() != null && !model.getQuestions().isEmpty()) this.questions = model.getQuestions();
        if (model.getGroup() != null) this.group = new UserGroup(model.getGroup());
        if (model.getAddress() != null) this.address = new Address(model.getAddress());
    }

    @Column(nullable = false, length = 70)
    private String name;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = false, unique = true)
    private String userName;

    @Column(nullable = false, length = 50)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birth;

    @Column(length = 20)
    private String phone;

    @Column(length = 1)
    private Integer flagMaster;

    private Integer extraTime;

    private String userToken;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private UserGroup group;

    @Column(length = 9)
    private Integer points = 0;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Question> questions;

    public void setFields(User user) {
        this.setName(user.getName());
        this.setEmail(user.getEmail());
        this.setUserName(user.getUserName());
        this.setPassword(user.getPassword());
        this.setBirth(user.getBirth());
        this.setPhone(user.getPhone());
    }

    @PrePersist
    @PreUpdate
    private void validate() throws Exception {
        String phone = this.phone;
        if (Utils.Email.isNotValid(this.email)) throw new Exception("Invalid e-mail");
        if (StringUtils.isBlank(phone) || Utils.Phone.isNotValid(phone)) throw new Exception("Invalid phone");
    }

}
