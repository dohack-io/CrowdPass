package com.doughhack.doughnotList.services;

import com.doughhack.doughnotList.dao.UserDao;
import com.doughhack.doughnotList.model.User;
import com.doughhack.doughnotList.exceptions.UserAlreadyExistsException;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    public void create(User user) throws UserAlreadyExistsException {
        if (!exist(user.getEmail())) {
            userDao.create(user);
        } else {
            throw new UserAlreadyExistsException();
        }
    }

    protected User getUser(String email) {
        return userDao.getUserByEmail(email);
    }

    public boolean exist(String email) {
        return getUser(email) != null;
    }

}
