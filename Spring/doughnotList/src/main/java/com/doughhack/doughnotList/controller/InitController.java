package com.doughhack.doughnotList.controller;


import com.doughhack.doughnotList.dto.ShoppingListDto;
import com.doughhack.doughnotList.exceptions.UserAlreadyExistsException;
import com.doughhack.doughnotList.model.Entry;
import com.doughhack.doughnotList.model.Profile;
import com.doughhack.doughnotList.model.ShoppingList;
import com.doughhack.doughnotList.model.User;
import com.doughhack.doughnotList.services.EntryService;
import com.doughhack.doughnotList.services.ProfileService;
import com.doughhack.doughnotList.services.ShoppingListService;
import com.doughhack.doughnotList.services.UserService;
import java.util.LinkedList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class InitController {

    public final UserService userService;

    public final ShoppingListService shoppingListService;

    public final ProfileService profileService;

    public final EntryService entryService;

    public InitController(UserService userService, ShoppingListService shoppingListService, ProfileService profileService, EntryService entryService) {
        this.userService = userService;
        this.shoppingListService = shoppingListService;
        this.profileService = profileService;
        this.entryService = entryService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/init")
    public ShoppingListDto init() throws UserAlreadyExistsException {

        String name = "iwan";
        String surname = "kornilow";
        String password = "test";
        String email = name + "." + surname + "@gmail.com";
        User user = new User(email, password, surname, name, surname + ", " + name);
        Profile profile = new Profile(name, surname, surname + ", " + name);
        profileService.create(profile);
        user.setProfile(profile);
        userService.create(user);
        ShoppingList shoppingList = new ShoppingList("testListe", profile);
        shoppingList.addMember(profile);

        name = "dimitri";
        surname = "Simonow";
        password = "test";
        email = name + "." + surname + "@gmail.com";
        user = new User(email, password, surname, name, surname + ", " + name);
        profile = new Profile(name, surname, surname + ", " + name);
        profileService.create(profile);
        user.setProfile(profile);
        userService.create(user);
        shoppingList.addMember(profile);

        name = "denise";
        surname = "Schwarze";
        password = "test";
        email = name + "." + surname + "@gmail.com";
        user = new User(email, password, surname, name, surname + ", " + name);
        profile = new Profile(name, surname, surname + ", " + name);
        profileService.create(profile);
        user.setProfile(profile);
        userService.create(user);
        shoppingList.addMember(profile);

        name = "valentin";
        surname = "saks";
        password = "test";
        email = name + "." + surname + "@gmail.com";
        user = new User(email, password, surname, name, surname + ", " + name);
        profile = new Profile(name, surname, surname + ", " + name);
        profileService.create(profile);
        user.setProfile(profile);
        userService.create(user);
        shoppingList.addMember(profile);

        shoppingListService.create(shoppingList);

        List<Entry> entries = new LinkedList<>();

        entries.add(new Entry("Heinz Barbeque", 1));
        entries.add(new Entry("Bier", 1));
        entries.add(new Entry("Cola", 1));
        entries.add(new Entry("Snickers", 1));
        entries.add(new Entry("Paprika", 1));

        for (Entry entry : entries) {
            entryService.create(entry);
            shoppingList.addEntry(entry);
        }

        shoppingListService.update(shoppingList);

        return shoppingList.toDto();
    }
}
