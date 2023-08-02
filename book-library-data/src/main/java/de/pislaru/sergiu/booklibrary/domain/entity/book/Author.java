package de.pislaru.sergiu.booklibrary.domain.entity.book;

import de.pislaru.sergiu.booklibrary.domain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.HashSet;
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
    @Override
    public String toString() {
        return "Author { "
                + super.toString()
                + ", firstName=" + firstName
                + ", lastName=" + lastName
                + ", birthPlace=" + birthPlace
                + ", bornOn=" + bornOn
                + ", diedOn=" + diedOn
                + ", biography {" + biography
                + "}}";
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
}
