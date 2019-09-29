package com.doughhack.doughnotList.dao;

import com.doughhack.doughnotList.model.Entity;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;

public class EntityListener {
    @PrePersist
    public void create(Object entity) {
        Entity e = (Entity) entity;
        e.setCreatedAt(now());

        update(entity);
    }

    @PostUpdate
    public void update(Object entity) {
        Entity e = (Entity) entity;
        e.setChangeAt(now());
    }

    private Date now() {
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        return new Date(System.currentTimeMillis());
    }
}
