package de.pislaru.sergiu.booklibrary.model.book;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Book extends BaseEntity {

    private String title;
    private String originalTitle;
    private String language;
    private CoverType coverType;
    private String numberOfPages;
    private String ISBN_10;
    private String ISBN_13;
    private String description;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "book_author",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "author_id"))
    private Set<Author> authors = new HashSet<>();

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Publisher.class)
    private Publisher publisher;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "book_genre",
    joinColumns = @JoinColumn(name = "book_id"),
    inverseJoinColumns = @JoinColumn(name = "genre_id"))
    private Set<Genre> genres = new HashSet<>();

    public Book() {
    }

    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getOriginalTitle() {return originalTitle;}
    public void setOriginalTitle(String originalTitle) {this.originalTitle = originalTitle;}
    public String getLanguage() {return language;}
    public void setLanguage(String language) {this.language = language;}
    public CoverType getCover() {return coverType;}
    public void setCover(CoverType coverType) {this.coverType = coverType;}
    public String getNumberOfPages() {return numberOfPages;}
    public void setNumberOfPages(String numberOfPages) {this.numberOfPages = numberOfPages;}
    public String getISBN_10() {return ISBN_10;}
    public void setISBN_10(String ISBN_10) {this.ISBN_10 = ISBN_10;}
    public String getISBN_13() {return ISBN_13;}
    public void setISBN_13(String ISBN_13) {this.ISBN_13 = ISBN_13;}
    public Set<Author> getAuthors() {return authors;}
    public void setAuthors(Set<Author> authors) {this.authors = authors;}
    public Publisher getPublisher() {return publisher;}
    public void setPublisher(Publisher publisher) {this.publisher = publisher;}
    public Set<Genre> getGenres() {return genres;}
    public void setGenres(Set<Genre> genres) {this.genres = genres;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        Book that = (Book) object;

        return Objects.equals(this.title, that.title) &&
                Objects.equals(this.originalTitle, that.originalTitle) &&
                Objects.equals(this.language, that.language) &&
                Objects.equals(this.coverType, that.coverType) &&
                Objects.equals(this.numberOfPages, that.numberOfPages) &&
                Objects.equals(this.ISBN_10, that.ISBN_10) &&
                Objects.equals(this.ISBN_13, that.ISBN_13) &&
                this.authors.equals(that.authors) &&
                Objects.equals(this.publisher, that.publisher) &&
                this.genres.equals(that.genres) &&
                Objects.equals(this.description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, originalTitle, language, coverType, numberOfPages, ISBN_10, ISBN_13, description, authors, publisher, genres);
    }

    @Override
    public String toString() {
        return "Book {"
                + "title=" + title
                + ", originalTitle=" + originalTitle
                + ", language=" + language
                + ", cover=" + coverType
                + ", numberOfPages=" + numberOfPages
                + ", ISBN-10=" + ISBN_10
                + ", ISBN-13=" + ISBN_13
                + ", publisher=" + publisher
                + ", description=" + description
                + " Authors {" + authors
                + "} Genres {" + genres
                + "}}"
                + super.toString();
    }
}
