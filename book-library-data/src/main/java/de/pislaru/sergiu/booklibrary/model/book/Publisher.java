package de.pislaru.sergiu.booklibrary.model.book;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher extends BaseEntity {

    private String name;
    private String email;
    private String phone;
    private String homePage;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "publisher", targetEntity = Book.class)
    private Set<Book> books = new HashSet<>();

    public Publisher() {
    }

    @Override
    public String toString() {
        return "Publisher { "
                + super.toString()
                + ", name=" + name
                + ", email=" + email
                + ", phone=" + phone
                + ", homePage=" + homePage
                + "}";
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
}
