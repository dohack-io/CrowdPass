package com.doughhack.doughnotList.controller;

import com.doughhack.doughnotList.exceptions.UserAlreadyExistsException;
import com.doughhack.doughnotList.model.User;
import com.doughhack.doughnotList.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    public String signUp(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password, @RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname) throws UserAlreadyExistsException {
        User user = new User(email, password, surname, name, surname + ", " + name);
        userService.create(user);

        return user.toString();
    }
}
