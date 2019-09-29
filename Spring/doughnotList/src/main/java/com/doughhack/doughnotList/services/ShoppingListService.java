package com.doughhack.doughnotList.services;

import com.doughhack.doughnotList.dao.ShoppingListDao;
import com.doughhack.doughnotList.model.ShoppingList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class ShoppingListService {
    public final ShoppingListDao shoppingListDao;

    public ShoppingListService(ShoppingListDao shoppingListDao) {
        this.shoppingListDao = shoppingListDao;
    }

    public void create(ShoppingList shoppingList) {
        shoppingListDao.create(shoppingList);
    }

    public void update(ShoppingList shoppingList) {
        shoppingListDao.update(shoppingList);
    }

    public ShoppingList getShoppingList(long id) {
        return shoppingListDao.getShoppingListGetId(id);
    }

    public void delete(long id) {
        shoppingListDao.delete(id);
    }
}
