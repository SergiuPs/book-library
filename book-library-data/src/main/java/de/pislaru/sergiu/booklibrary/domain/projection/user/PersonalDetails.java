package de.pislaru.sergiu.booklibrary.domain.projection.user;

import java.time.LocalDate;

public final class PersonalDetails {

    private final Long id;
    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final LocalDate birthDate;
    private final String avatar;

    public PersonalDetails(Long id, String username, String email, String firstName, String lastName, LocalDate birthDate, String avatar) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.avatar = avatar;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " {" +
                "Id=" + this.id + ", " +
                "Username=" + this.username + ", " +
                "Email=" + this.email + ", " +
                "FirstName=" + this.firstName + ", " +
                "LastName=" + this.lastName + ", " +
                "BirthDate" + this.birthDate + ", " +
                "Avatar=" + this.avatar + "}";
    }

    public Long getId() {return id;}
    public String getUsername() {return username;}
    public String getEmail() {return email;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
    public LocalDate getBirthDate() {return birthDate;}
    public String getAvatar() {return avatar;}
}
