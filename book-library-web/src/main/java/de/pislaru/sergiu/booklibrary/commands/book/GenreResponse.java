package de.pislaru.sergiu.booklibrary.commands.book;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GenreResponse implements Serializable {

    private Long id;
    private String name;
    private Set<BookResponse> books = new HashSet<>();

    public GenreResponse() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GenreResponse that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    @Override
    public String toString() {
        return "GenreResponse {"
                + "id=" + id
                + ", name=" + name
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Set<BookResponse> getBooks() {return books;}
    public void setBooks(Set<BookResponse> books) {this.books = books;}
}
