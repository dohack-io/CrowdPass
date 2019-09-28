package com.doughhack.doughnotList.model;

import com.doughhack.doughnotList.dto.ProfileDto;
import com.doughhack.doughnotList.dto.UserDto;
import java.util.Objects;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Table(name = User.TABLE_NAME)
@NamedQueries({
        @NamedQuery(name = User.EXISTS_QUERY, query = "select u from " + User.TABLE_NAME + " u where u.email = :" + User.EMAIL_PARAM),
        @NamedQuery(name = User.ALL_QUERY, query = "select u from " + User.TABLE_NAME + " u")
})
@javax.persistence.Entity
public class User extends Entity {
    public static final String TABLE_NAME = "User";
    public static final String EXISTS_QUERY = TABLE_NAME + ".exists";
    public static final String ALL_QUERY = TABLE_NAME + ".all";

    public static final String EMAIL_PARAM = "email";

    private String email;
    private String hashedPW;
    @OneToOne
    private Profile profile;

    public User() {
    }

    public User(String mail, String pw, String name, String vorname, String profilename) {
        this.email = mail;
        this.hashedPW = pw;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
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

    public UserDto toDto() {
        ProfileDto profile = this.profile.toDto();

        return new UserDto(email, hashedPW, profile);
    }

}
