package com.doughhack.doughnotList.controller;

import com.doughhack.doughnotList.dto.EntryDto;
import com.doughhack.doughnotList.model.Entry;
import com.doughhack.doughnotList.services.EntryService;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class EntryController {
    private static final String PATH = "/Entry";

    private final EntryService entryService;

    public EntryController(EntryService entryService) {
        this.entryService = entryService;
    }

    @RequestMapping(method = RequestMethod.POST, value = PATH + "/create")
    public EntryDto create(@RequestParam(value = "name") String name, @RequestParam(value = "barcode") String barcodeNr, @RequestParam int amount) {
        Entry entry = new Entry(name, amount);
        entry.setBarcodeNr(barcodeNr != null ? barcodeNr : "");
        entryService.create(entry);
        return entry.toDto();
    }

    @RequestMapping(method = RequestMethod.POST, value = PATH + "/update")
    public EntryDto update(@RequestBody EntryDto entryDto) {
        Entry entry = entryService.getEntry(entryDto.id);
        entry.setName(entryDto.name);
        entry.setBarcodeNr(entryDto.barcodeNr);
        entry.setAmount(entryDto.amount);
        entryService.update(entry);
        return entry.toDto();
    }

    @RequestMapping(method = RequestMethod.GET, value = PATH + "/get/{id}")
    public EntryDto getEntry(@PathVariable long id) {
        Entry entry = entryService.getEntry(id);
        return entry.toDto();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = PATH + "/delete/{id}")
    public void delete(@PathVariable long id) {
        entryService.delete(id);
    }
}
