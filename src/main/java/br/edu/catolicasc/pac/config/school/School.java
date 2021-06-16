package br.edu.catolicasc.pac.config.school;

import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.classroom.Classroom;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class School extends AbstractEntity {

    @Column(nullable = false)
    private String name;

    @OneToOne
    private Address address;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private List<Classroom> classes;

}
