package com.doughhack.doughnotList.model;

import com.doughhack.doughnotList.dto.EntryDto;
import com.doughhack.doughnotList.dto.ProfileDto;
import com.doughhack.doughnotList.dto.ShoppingListDto;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = "Shoppinglist")
@javax.persistence.Entity
public class ShoppingList extends Entity {

    private String name;
    @OneToMany
    private List<Entry> entries;
    @OneToMany
    private List<Profile> member;
    @OneToOne
    private Profile admin;

    public ShoppingList() {
    }

    public ShoppingList(String name, Profile admin) {
        this.name = name;
        this.entries = new ArrayList();
        this.member = new ArrayList();
        this.admin = admin;
    }

    public void addEntry(String name) {
        entries.add(new Entry(name));
    }

    public void addEntry(String name, int amount) {
        entries.add(new Entry(name, amount));
    }

    public void addMember(Profile member) {
        this.member.add(member);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ShoppingListDto toDto() {
        ShoppingListDto shoppingListDto = new ShoppingListDto(getId(), name, admin.toDto());
        List<EntryDto> entryDtos = new LinkedList<>();
        for (Entry entry : entries) {
            entryDtos.add(entry.toDto());
        }
        shoppingListDto.entries = entryDtos;
        List<ProfileDto> profileDtos = new LinkedList<>();
        for (Profile profile : member) {
            profileDtos.add(profile.toDto());
        }
        shoppingListDto.members = profileDtos;
        return shoppingListDto;
    }

}
