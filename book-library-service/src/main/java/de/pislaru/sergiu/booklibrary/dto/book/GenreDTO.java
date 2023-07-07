package de.pislaru.sergiu.booklibrary.dto.book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GenreDTO {

    private Long id;
    private String name;
    private Set<BookDTO> books = new HashSet<>();

    public GenreDTO() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof GenreDTO that)) {
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
        return "GenreDTO {"
                + "id=" + id
                + ", name=" + name
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Set<BookDTO> getBooks() {return books;}
    public void setBooks(Set<BookDTO> books) {this.books = books;}
}
