package br.edu.catolicasc.pac.config.uf;

import br.edu.catolicasc.utils.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class UF extends AbstractEntity {

    @Column(length = 2)
    private String uf;

    @Column(length = 30)
    private String name;

}
