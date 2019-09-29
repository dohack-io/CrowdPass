package com.doughhack.doughnotList.dto;

import java.util.LinkedList;
import java.util.List;

public class ShoppingListDto implements DoughNotDto {
    public long id;
    public String name;
    public ProfileDto admin;
    public List<ProfileDto> members;
    public List<EntryDto> entries;

    public ShoppingListDto(long id, String name, ProfileDto admin) {
        this.id = id;
        this.name = name;
        this.admin = admin;

        this.members = new LinkedList<>();
        this.members = new LinkedList<>();
    }

    @Override
    public String toString() {
        return "ShoppingListDto{"
                + " name='" + name + '\''
                + ", admin=" + admin
                + ", members=" + members
                + '}';
    }
}
