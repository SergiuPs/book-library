package de.pislaru.sergiu.booklibrary.commands.book;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.model.book.Book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class GenreCommand extends BaseEntityCommand {

    private String name;

    private Set<Book> books = new HashSet<>();

    public GenreCommand() {
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

        GenreCommand that = (GenreCommand) object;

        return Objects.equals(this.name, that.name);
    }

    @Override
    public String toString() {
        return "GenreCommand {"
                + "name=" + name
                + "}"
                + super.toString();
    }
}
