package br.edu.catolicasc.utils;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@EqualsAndHashCode
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id;

    @Temporal(TIMESTAMP)
    @Column(name = "created_at")
    protected Date createdAt;

    @Temporal(TIMESTAMP)
    @Column(name = "updated_at")
    protected Date updatedAt;

    @PrePersist
    @PreUpdate
    private void save(){
        if (getId() == null) {
            setCreatedAt(new Date());
        }
        setUpdatedAt(new Date());
    }

    public abstract Long getId();

    public abstract void setId(Long id);

}
