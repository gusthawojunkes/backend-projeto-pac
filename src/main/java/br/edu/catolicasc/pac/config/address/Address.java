package br.edu.catolicasc.pac.config.address;

import br.edu.catolicasc.pac.config.uf.UF;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 60)
    private String city;

    @OneToOne
    private UF uf;

}
