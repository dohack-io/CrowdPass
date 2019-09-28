package com.doughhack.doughnotList.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends Entity {

    private String name;
    private List<Entry> entries;
    private List<Profile> member;
    private Profile admin;

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
}
