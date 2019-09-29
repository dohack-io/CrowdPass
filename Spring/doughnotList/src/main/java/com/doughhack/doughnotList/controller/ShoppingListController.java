package com.doughhack.doughnotList.controller;

import com.doughhack.doughnotList.dto.ShoppingListDto;
import com.doughhack.doughnotList.model.Profile;
import com.doughhack.doughnotList.model.ShoppingList;
import com.doughhack.doughnotList.services.ProfileService;
import com.doughhack.doughnotList.services.ShoppingListService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class ShoppingListController {
    private static final String PATH = "/ShoppingList";

    public final ProfileService profileService;

    public final ShoppingListService shoppingListService;

    public ShoppingListController(ProfileService profileService, ShoppingListService shoppingListService) {
        this.profileService = profileService;
        this.shoppingListService = shoppingListService;
    }

    @RequestMapping(method = RequestMethod.POST, value = PATH + "/create")
    public ShoppingListDto create(@RequestParam long adminId, @RequestParam String name) {
        Profile admin = profileService.getProfileById(adminId);

        ShoppingList shoppingList = new ShoppingList(name, admin);
        shoppingListService.create(shoppingList);
        return shoppingList.toDto();
    }
}
