package com.doughhack.doughnotList.dao;

import com.doughhack.doughnotList.model.Entry;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class EntryDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Entry entry) {
        entityManager.persist(entry);
    }

    public void update(Entry entry) {
        entityManager.merge(entry);
    }

    public Entry getEntryById(long id) {
        return entityManager.find(Entry.class, id);
    }

    public void delete(long id) {
        Entry entry = getEntryById(id);
        if (entry != null) entityManager.remove(entry);
    }
}
