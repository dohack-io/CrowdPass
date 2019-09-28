package com.doughhack.doughnotList.dto;

import java.util.List;

public class ProfileDto implements DoughNotDto {
    public String profileName;
    public String firstName;
    public String lsatName;

    public List<PreferenceDto> blackList;

    public ProfileDto(String profileName, String firstName, String lsatName) {
        this.profileName = profileName;
        this.firstName = firstName;
        this.lsatName = lsatName;
    }

    @Override
    public String toString() {
        return "ProfileDto{"
                + " profileName='" + profileName + '\''
                + ", firstName='" + firstName + '\''
                + ", lsatName='" + lsatName + '\''
                + ", blackList=" + blackList
                + '}';
    }
}
