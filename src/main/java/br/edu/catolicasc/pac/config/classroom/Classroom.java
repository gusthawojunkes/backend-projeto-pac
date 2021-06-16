package br.edu.catolicasc.pac.config.classroom;

import br.edu.catolicasc.pac.config.school.School;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Entity
public class Classroom extends AbstractEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
