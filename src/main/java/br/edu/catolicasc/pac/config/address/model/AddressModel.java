package br.edu.catolicasc.pac.config.address.model;

import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.uf.UF;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter
public class AddressModel {

    public AddressModel(Address address) {
        this.city = address.getCity();
        UF uf = address.getUf();
        if (uf != null) {
           this.uf = StringUtils.isNotBlank(uf.getUf()) ? uf.getUf() : "";
           this.ufName = StringUtils.isNotBlank(uf.getName()) ? uf.getName() : "";
        }
    }

    private String city;

    private String uf;

    private String ufName;
}
