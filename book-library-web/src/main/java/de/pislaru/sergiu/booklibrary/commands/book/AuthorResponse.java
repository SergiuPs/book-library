package de.pislaru.sergiu.booklibrary.commands.book;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AuthorResponse implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String birthPlace;
    private LocalDate bornOn;
    private LocalDate diedOn;
    private String biography;
    private Set<BookResponse> books = new HashSet<>();

    public AuthorResponse() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof AuthorResponse that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.birthPlace, that.birthPlace) &&
                Objects.equals(this.bornOn, that.bornOn) &&
                Objects.equals(this.diedOn, that.diedOn) &&
                Objects.equals(this.biography, that.biography) &&
                Objects.equals(this.books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, birthPlace, bornOn, diedOn, biography, books);
    }

    @Override
    public String toString() {
        return "AuthorResponse {"
                + "id=" + id
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", birthPlace=" + birthPlace
                + ", bornOn=" + bornOn
                + ", diedOn=" + diedOn
                + ", biography {" + biography
                + "}}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getBirthPlace() {return birthPlace;}
    public void setBirthPlace(String birthPlace) {this.birthPlace = birthPlace;}
    public LocalDate getBornOn() {return bornOn;}
    public void setBornOn(LocalDate bornOn) {this.bornOn = bornOn;}
    public LocalDate getDiedOn() {return diedOn;}
    public void setDiedOn(LocalDate diedOn) {this.diedOn = diedOn;}
    public String getBiography() {return biography;}
    public void setBiography(String biography) {this.biography = biography;}
    public Set<BookResponse> getBooks() {return books;}
    public void setBooks(Set<BookResponse> books) {this.books = books;}


}
