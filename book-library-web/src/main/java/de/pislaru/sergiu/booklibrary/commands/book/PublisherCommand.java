package de.pislaru.sergiu.booklibrary.commands.book;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.model.book.Book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PublisherCommand extends BaseEntityCommand {

    private String name;
    private String email;
    private String phone;
    private String homePage;

    private Set<Book> books = new HashSet<>();

    public PublisherCommand() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}
    public String getHomePage() {return homePage;}
    public void setHomePage(String homePage) {this.homePage = homePage;}
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

        PublisherCommand that = (PublisherCommand) object;

        return  Objects.equals(this.name, that.name) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.phone, that.phone) &&
                Objects.equals(this.homePage, that.homePage) &&
                this.books.equals(that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, email, phone, homePage, books);
    }

    @Override
    public String toString() {
        return "PublisherCommand {"
                + "name=" + name
                + ", email=" + email
                + ", phone=" + phone
                + ", homePage=" + homePage
                + "}"
                + super.toString();
    }
}
