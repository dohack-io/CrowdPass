package com.doughhack.doughnotList.dto;

public class UserDto implements DoughNotDto {
    public String email;
    public String hashedPW;

    public ProfileDto profile;

    public UserDto(String email, String hashedPW, ProfileDto profile) {
        this.email = email;
        this.hashedPW = hashedPW;
        this.profile = profile;
    }
}
