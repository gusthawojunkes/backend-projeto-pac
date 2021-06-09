package br.edu.catolicasc.pac.config.address;

import br.edu.catolicasc.pac.config.uf.UF;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Address extends AbstractEntity {

    @Column(length = 60)
    private String city;

    @OneToOne
    private UF uf;

}
