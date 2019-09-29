package com.doughhack.doughnotList.dao;

import com.doughhack.doughnotList.model.ShoppingList;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

@Repository
public class ShoppingListDao {
    @PersistenceContext
    private EntityManager entityManager;

    public void create(ShoppingList shoppingList) {
        entityManager.persist(shoppingList);
    }

    public void update(ShoppingList shoppingList) {
        entityManager.merge(shoppingList);
    }

    public ShoppingList getShoppingListGetId(long id) {
        return entityManager.find(ShoppingList.class, id);
    }

    public void delete(long id) {
        ShoppingList shoppingList = getShoppingListGetId(id);
        if (shoppingList != null) entityManager.remove(shoppingList);
    }
}
