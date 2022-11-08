package de.pislaru.sergiu.booklibrary.model.book;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Genre extends BaseEntity {

    private String name;

    @ManyToMany(mappedBy = "genres")
    private Set<Book> books = new HashSet<>();

    public Genre() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Set<Book> getBooks() {return books;}
    public void setBooks(Set<Book> books) {this.books = books;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return false;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        Genre that = (Genre) object;

        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "Genre {"
                + "name=" + name
                + "}"
                + super.toString();
    }
}
