package br.edu.catolicasc.pac.config.classroom;

import br.edu.catolicasc.pac.config.classroom.model.ClassroomModel;
import br.edu.catolicasc.pac.config.school.School;
import br.edu.catolicasc.utils.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Classroom extends AbstractEntity {

    public Classroom(ClassroomModel model) {
        this.name = model.getName();
        this.school = new School(model.getSchool());
    }

    private String name;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

    public static List<Classroom> getClassesByListModel(List<ClassroomModel> listModel) {
        List<Classroom> listRet = new ArrayList<>();
        for (ClassroomModel model : listModel) {
            listRet.add(new Classroom(model));
        }
        return listRet;
    }

}
