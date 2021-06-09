package br.edu.catolicasc.pac.config.group;

import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class UserGroup extends AbstractEntity {

    @Column(nullable = false, length = 30)
    private String name;

    @Column(nullable = false, length = 100)
    private String description;

}
