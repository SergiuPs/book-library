package de.pislaru.sergiu.booklibrary.dto.book;

import de.pislaru.sergiu.booklibrary.model.book.Book;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class PublisherDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private String homePage;

    private Set<Book> books = new HashSet<>();

    public PublisherDTO() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PublisherDTO that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.phone, that.phone) &&
                Objects.equals(this.homePage, that.homePage) &&
                Objects.equals(this.books, that.books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email, phone, homePage, books.hashCode());
    }

    @Override
    public String toString() {
        return "PublisherDTO {"
                + "id=" + id
                + ", name=" + name
                + ", email=" + email
                + ", phone=" + phone
                + ", homePage=" + homePage
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
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
}
