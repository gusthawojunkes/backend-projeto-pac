package br.edu.catolicasc.pac.config.permissions;

import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Permissions extends AbstractEntity {

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String description;

}
