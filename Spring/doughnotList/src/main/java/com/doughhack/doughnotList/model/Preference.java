package com.doughhack.doughnotList.model;

import com.doughhack.doughnotList.dto.PreferenceDto;

public class Preference extends Entity {
    private String name;
    private String type;

    public Preference(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public PreferenceDto toDto() {
        return new PreferenceDto(name, type);
    }
}
