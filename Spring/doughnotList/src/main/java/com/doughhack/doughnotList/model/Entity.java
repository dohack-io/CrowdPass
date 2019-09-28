package com.doughhack.doughnotList.model;

import com.doughhack.doughnotList.dao.EntityListener;
import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@EntityListeners({EntityListener.class})
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Date createdAt;
    private Date changeAt;

    public Entity() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getChangeAt() {
        return changeAt;
    }

    public void setChangeAt(Date changeAt) {
        this.changeAt = changeAt;
    }
}
