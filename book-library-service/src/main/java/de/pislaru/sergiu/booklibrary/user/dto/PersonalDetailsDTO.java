package de.pislaru.sergiu.booklibrary.user.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class PersonalDetailsDTO implements Serializable {

    private Long id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String avatar;

    public PersonalDetailsDTO() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " {" +
                "Id=" + this.id + ", " +
                "Username=" + this.username + ", " +
                "Email=" + this.email + ", " +
                "FirstName=" + this.firstName + ", " +
                "LastName=" + this.lastName + ", " +
                "BirthDate=" + this.birthDate + ", " +
                "Avatar=" + this.avatar + "}";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
