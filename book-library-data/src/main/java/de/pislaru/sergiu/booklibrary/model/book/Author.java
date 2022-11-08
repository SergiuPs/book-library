package de.pislaru.sergiu.booklibrary.model.book;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Author extends BaseEntity {

    private String firstName;
    private String lastName;
    private String birthPlace;
    private LocalDate bornOn;
    private LocalDate diedOn;
    private String biography;

    @ManyToMany(mappedBy = "authors")
    private Set<Book> books = new HashSet<>();

    public Author() {
    }

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
    public Set<Book> getBooks() {return books;}
    public void setBooks(Set<Book> books) {this.books = books;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        Author that = (Author) object;

        return  Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.birthPlace, that.birthPlace) &&
                Objects.equals(this.bornOn, that.bornOn) &&
                Objects.equals(this.diedOn, that.diedOn) &&
                Objects.equals(this.biography, that.biography) &&
                books.equals(that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, birthPlace, bornOn, diedOn, biography, books);
    }

    @Override
    public String toString() {
        return "Author {"
                + "firstName=" + firstName
                + ", lastName=" + lastName
                + ", birthPlace=" + birthPlace
                + ", bornOn=" + bornOn
                + ", diedOn=" + diedOn
                + ", biography {" + biography
                + "}}"
                + super.toString();
    }
}
