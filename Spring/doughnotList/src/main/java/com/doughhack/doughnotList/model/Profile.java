package com.doughhack.doughnotList.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Profile extends Entity{
    private String firstName;
    private String lastName;
    private String profileName;
    private List<Preference> blacklist;

    public Profile(String firstName, String lastName, String profileName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profileName = profileName;
        this.blacklist = new ArrayList();
    }


    @Override
    public String toString() {
        return "Profile{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", profileName='" + profileName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return firstName.equals(profile.firstName) &&
                lastName.equals(profile.lastName) &&
                profileName.equals(profile.profileName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, profileName);
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }
}

