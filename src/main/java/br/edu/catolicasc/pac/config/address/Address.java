package br.edu.catolicasc.pac.config.address;

import br.edu.catolicasc.pac.config.address.model.AddressModel;
import br.edu.catolicasc.pac.config.uf.UF;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class Address extends AbstractEntity {

    public Address(AddressModel address) {
        this.city = address.getCity();
        this.uf = new UF(address.getUf(), address.getUfName());
    }

    @Column(length = 60)
    private String city;

    @OneToOne
    private UF uf;

}
