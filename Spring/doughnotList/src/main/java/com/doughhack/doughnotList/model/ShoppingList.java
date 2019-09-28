package com.doughhack.doughnotList.model;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList extends Entity {

    private String name;
    private List<Entry> entries;


    public ShoppingList(String name) {
        this.name = name;
        this.entries = new ArrayList();
    }

    public void addEntry(String name) {
        entries.add(new Entry(name));
    }

    public void addEntry(String name, int amount) {
        entries.add(new Entry(name, amount));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
