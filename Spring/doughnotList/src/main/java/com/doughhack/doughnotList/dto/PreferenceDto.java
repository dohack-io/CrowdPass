package com.doughhack.doughnotList.dto;

public class PreferenceDto implements DoughNotDto {
    public String name;
    public String type;

    public PreferenceDto(String name, String type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public String toString() {
        return "PreferenceDto{"
                + " name='" + name + '\''
                + ", type='" + type + '\''
                + '}';
    }
}
