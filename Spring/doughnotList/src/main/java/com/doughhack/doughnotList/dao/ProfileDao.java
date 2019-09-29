package com.doughhack.doughnotList.dao;

import com.doughhack.doughnotList.model.Profile;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ProfileDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(Profile profile) {
        entityManager.persist(profile);
    }

    public void update(Profile profile) {
        entityManager.merge(profile);
    }

    public Profile getProfileById(long id) {
        return entityManager.find(Profile.class, id);
    }

    public void delete(long id) {
        Profile profile = getProfileById(id);
        if (profile != null) entityManager.remove(profile);
    }
}
