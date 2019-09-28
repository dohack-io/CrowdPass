package com.doughhack.doughnotList.model;

import java.util.ArrayList;
import java.util.Objects;

public class User extends Entity {
    private String email;
    private String hashedPW;
    private Profile profile;

    public User(String mail, String pw, String name, String vorname, String profilename) {
        this.email = mail;
        this.hashedPW = pw;
    }

    public void newProfile(String vorname, String name, String profilename) {
        this.profile = new Profile(vorname, name, profilename);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email.equals(user.email);
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(email);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashedPW() {
        return hashedPW;
    }

    public void setHashedPW(String hashedPW) {
        this.hashedPW = hashedPW;
    }

}
