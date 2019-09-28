package com.doughhack.doughnotList.dto;

import java.util.LinkedList;
import java.util.List;

public class ShoppingListDto implements DoughNotDto {
    public String name;
    public ProfileDto admin;
    public List<ProfileDto> members;

    public ShoppingListDto(String name, ProfileDto admin) {
        this.name = name;
        this.admin = admin;

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
