package com.doughhack.doughnotList.dao;

import com.doughhack.doughnotList.model.Preference;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class PreferenceDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Preference preference) {
        entityManager.persist(preference);
    }

    public void update(Preference preference) {
        entityManager.merge(preference);
    }

    public Preference getPreferenceById(long id) {
        return entityManager.find(Preference.class, id);
    }

    public void delete(long id) {
        Preference preference = getPreferenceById(id);
        if (preference != null) entityManager.remove(preference);
    }
}
