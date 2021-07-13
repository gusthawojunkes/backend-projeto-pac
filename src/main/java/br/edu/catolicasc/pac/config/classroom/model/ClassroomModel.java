package br.edu.catolicasc.pac.config.classroom.model;

import br.edu.catolicasc.pac.config.classroom.Classroom;
import br.edu.catolicasc.pac.config.school.model.SchoolModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassroomModel {

    public ClassroomModel(Classroom classroom) {
        this.name = classroom.getName();
        this.school = new SchoolModel(classroom.getSchool());
    }

    private String name;

    private SchoolModel school;

}
