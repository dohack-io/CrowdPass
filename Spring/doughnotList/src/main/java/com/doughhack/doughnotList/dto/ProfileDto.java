package com.doughhack.doughnotList.dto;

import java.util.LinkedList;
import java.util.List;

public class ProfileDto implements DoughNotDto {
    public long id;
    public String profileName;
    public String firstName;
    public String lsatName;

    public List<PreferenceDto> blackList;

    public ProfileDto(long id, String profileName, String firstName, String lsatName) {
        this.id = id;
        this.profileName = profileName;
        this.firstName = firstName;
        this.lsatName = lsatName;

        this.blackList = new LinkedList<>();
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
