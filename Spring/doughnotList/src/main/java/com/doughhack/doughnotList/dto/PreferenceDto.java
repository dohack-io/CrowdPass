package com.doughhack.doughnotList.dto;

public class PreferenceDto implements DoughNotDto {
    public long id;
    public String name;
    public String type;

    public PreferenceDto(long id, String name, String type) {
        this.id = id;
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
