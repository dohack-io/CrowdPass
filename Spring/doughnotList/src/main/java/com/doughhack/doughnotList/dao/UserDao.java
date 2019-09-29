package com.doughhack.doughnotList.dao;

import com.doughhack.doughnotList.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public User getUserByEmail(String email) {
        TypedQuery<User> query = entityManager.createNamedQuery(User.EXISTS_QUERY, User.class);
        query.setParameter(User.EMAIL_PARAM, email);
        try {
            return query.getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public void delete(long id) {
        User user = getUserById(id);
        if (user != null) entityManager.remove(user);
    }

    public List<User> getAllUser() {
        TypedQuery<User> query = entityManager.createNamedQuery(User.ALL_QUERY, User.class);
        return query.getResultList();
    }
}
