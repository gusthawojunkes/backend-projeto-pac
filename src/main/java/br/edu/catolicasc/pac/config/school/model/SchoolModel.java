package br.edu.catolicasc.pac.config.school.model;

import br.edu.catolicasc.pac.config.address.model.AddressModel;
import br.edu.catolicasc.pac.config.classroom.model.ClassroomModel;
import br.edu.catolicasc.pac.config.school.School;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SchoolModel {

    public SchoolModel(School school) {
        this.name = school.getName();

    }

    private String name;

    private AddressModel address;

    private List<ClassroomModel> classes;

}
