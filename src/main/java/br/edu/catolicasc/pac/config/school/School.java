package br.edu.catolicasc.pac.config.school;

import br.edu.catolicasc.pac.config.address.Address;
import br.edu.catolicasc.pac.config.classroom.Classroom;
import br.edu.catolicasc.pac.config.school.model.SchoolModel;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.collections4.CollectionUtils;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
public class School extends AbstractEntity {

    public School(SchoolModel model) {
        this.name = model.getName();
        if (model.getAddress() != null) this.address = new Address(model.getAddress());
        if (CollectionUtils.isNotEmpty(model.getClasses())) this.classes = Classroom.getClassesByListModel(model.getClasses());
    }

    @Column(nullable = false)
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToMany(orphanRemoval = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "school_id")
    private List<Classroom> classes;

}
