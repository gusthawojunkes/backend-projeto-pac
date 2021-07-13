package br.edu.catolicasc.pac.config.school.model;

import br.edu.catolicasc.pac.config.address.model.AddressModel;
import br.edu.catolicasc.pac.config.classroom.Classroom;
import br.edu.catolicasc.pac.config.classroom.model.ClassroomModel;
import br.edu.catolicasc.pac.config.school.School;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SchoolModel {

    public SchoolModel(School school) {
        this.name = school.getName();
        this.address = new AddressModel(school.getAddress());
        this.classes = getModelList(school.getClasses());
    }

    private String name;

    private AddressModel address;

    private List<ClassroomModel> classes;

    private List<ClassroomModel> getModelList(List<Classroom> classes) {
        List<ClassroomModel> listReturn = new ArrayList<>();

        for (Classroom classroom : classes) {
            ClassroomModel model = new ClassroomModel(classroom);
            listReturn.add(model);
        }

        return listReturn;
    }

}
