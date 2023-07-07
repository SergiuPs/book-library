package de.pislaru.sergiu.booklibrary.model.book;

import de.pislaru.sergiu.booklibrary.model.BaseEntityInfo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GenreInfo extends BaseEntityInfo {

    private String name;

    private Set<Book> books = new HashSet<>();

    public GenreInfo() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
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

        GenreInfo that = (GenreInfo) object;

        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name);
    }

    @Override
    public String toString() {
        return "GenreInfo {"
                + "name=" + name
                + "}"
                + super.toString();
    }
}
