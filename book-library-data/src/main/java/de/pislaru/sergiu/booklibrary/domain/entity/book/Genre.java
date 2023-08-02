package de.pislaru.sergiu.booklibrary.domain.entity.book;

import de.pislaru.sergiu.booklibrary.domain.entity.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books = new HashSet<>();

    public Genre() {
    }
    @Override
    public String toString() {
        return "Genre { "
                + super.toString()
                + ", name=" + name
                + "}";
    }


    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Set<Book> getBooks() {return books;}
    public void setBooks(Set<Book> books) {this.books = books;}
}
