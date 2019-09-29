package com.doughhack.doughnotList.controller;

import com.doughhack.doughnotList.dto.PreferenceDto;
import com.doughhack.doughnotList.model.Preference;
import com.doughhack.doughnotList.services.PreferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

@RestController
@EnableAutoConfiguration
public class PreferenceController {
    private static final String PATH = "/Preference";
    private final PreferenceService preferenceService;

    public PreferenceController(PreferenceService preferenceService) {
        this.preferenceService = preferenceService;
    }


    @RequestMapping(method = RequestMethod.POST, value = PATH + "/create")
    public PreferenceDto create(@RequestParam(value = "name") String name, @RequestParam(value = "type") String type) {
        Preference preference = new Preference(name, type);
        preferenceService.create(preference);
        return preference.toDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = PATH + "/update")
    public PreferenceDto update(@RequestBody PreferenceDto preferenceDto) {
        Preference preference = preferenceService.getPreference(preferenceDto.id);
        preference.setName(preferenceDto.name);
        preference.setType(preferenceDto.type);
        preferenceService.update(preference);
        return preference.toDto();
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH + "/get{id}")
    public PreferenceDto get(@PathVariable long id) {
        return preferenceService.getPreference(id).toDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = PATH + "/get{id}")
    public void delete(@PathVariable long id) {
        preferenceService.delete(id);
    }

}

