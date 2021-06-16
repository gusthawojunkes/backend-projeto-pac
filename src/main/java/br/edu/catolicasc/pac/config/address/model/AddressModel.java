package br.edu.catolicasc.pac.config.address.model;

import br.edu.catolicasc.pac.config.address.Address;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressModel {

    public AddressModel(Address address) {

    }

    private String city;

    private String uf;

    private String ufName;
}
