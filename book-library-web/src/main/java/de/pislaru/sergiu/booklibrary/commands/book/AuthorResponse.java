package de.pislaru.sergiu.booklibrary.commands.book;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.model.book.Book;

import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class AuthorCommand extends BaseEntityCommand {

    @Size(min = 2, max = 100)
    private String firstName;

    @Size(min = 2, max = 100)
    private String lastName;

    @Size(min = 3, max = 100)
    private String birthPlace;

    @Past
    private LocalDate bornOn;

    private LocalDate diedOn;
    private String biography;

    private Set<Book> books = new HashSet<>();

    public AuthorCommand() {
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

        AuthorCommand that = (AuthorCommand) object;

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
        return "AuthorCommand {"
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
