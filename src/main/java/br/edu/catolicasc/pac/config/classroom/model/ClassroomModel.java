package br.edu.catolicasc.pac.config.classroom.model;

import br.edu.catolicasc.pac.config.classroom.Classroom;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassroomModel {

    public ClassroomModel(Classroom classroom) {
        this.classroom = classroom.getName();
    }

    private String classroom;

}
