package com.doughhack.doughnotList.controller;

import com.doughhack.doughnotList.dto.ProfileDto;
import com.doughhack.doughnotList.dto.UserDto;
import com.doughhack.doughnotList.exceptions.UserAlreadyExistsException;
import com.doughhack.doughnotList.model.Profile;
import com.doughhack.doughnotList.model.User;
import com.doughhack.doughnotList.services.ProfileService;
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
    private static final String PATH = "/User";

    private final UserService userService;

    private final ProfileService profileService;

    public UserController(UserService userService, ProfileService profileService) {
        this.userService = userService;
        this.profileService = profileService;
    }

    @RequestMapping(method = RequestMethod.POST, path = "/signup")
    public ProfileDto signUp(@RequestParam(value = "email") String email, @RequestParam(value = "password") String password, @RequestParam(value = "name") String name, @RequestParam(value = "surname") String surname) throws UserAlreadyExistsException {
        User user = new User(email, password, surname, name, surname + ", " + name);
        Profile profile = new Profile(name, surname, surname + ", " + name);
        profileService.create(profile);
        user.setProfile(profile);
        userService.create(user);

        return profile.toDto();
    }
}
