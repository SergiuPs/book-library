package de.pislaru.sergiu.booklibrary.payload.response.user.book;

import de.pislaru.sergiu.booklibrary.model.book.CoverType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BookResponse implements Serializable {

    private Long id;
    private String title;
    private String originalTitle;
    private String language;
    private CoverType coverType;
    private String numberOfPages;
    private String ISBN_10;
    private String ISBN_13;
    private String description;

    private Set<AuthorResponse> authors = new HashSet<>();
    private PublisherResponse publisher;
    private Set<GenreResponse> genres = new HashSet<>();

    public BookResponse() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof BookResponse that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.title, that.title) &&
                Objects.equals(this.originalTitle, that.originalTitle) &&
                Objects.equals(this.language, that.language) &&
                Objects.equals(this.coverType, that.coverType) &&
                Objects.equals(this.numberOfPages, that.numberOfPages) &&
                Objects.equals(this.ISBN_10, that.ISBN_10) &&
                Objects.equals(this.ISBN_13, that.ISBN_13) &&
                Objects.equals(this.authors, that.authors) &&
                Objects.equals(this.publisher, that.publisher) &&
                Objects.equals(this.genres, that.genres) &&
                Objects.equals(this.description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, originalTitle, language, coverType, numberOfPages,
                            ISBN_10, ISBN_13, description, authors, publisher, genres);
    }

    @Override
    public String toString() {
        return "BookResponse {"
                + "id=" + id
                + ", title=" + title
                + ", originalTitle=" + originalTitle
                + ", language=" + language
                + ", cover=" + coverType
                + ", numberOfPages=" + numberOfPages
                + ", ISBN-10=" + ISBN_10
                + ", ISBN-13=" + ISBN_13
                + ", publisher=" + publisher
                + ", description=" + description
                + " Authors {" + authors.toString()
                + "} Genres {" + genres.toString()
                + "}}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getTitle() {return title;}
    public void setTitle(String title) {this.title = title;}
    public String getOriginalTitle() {return originalTitle;}
    public void setOriginalTitle(String originalTitle) {this.originalTitle = originalTitle;}
    public String getLanguage() {return language;}
    public void setLanguage(String language) {this.language = language;}
    public CoverType getCoverType() {return coverType;}
    public void setCoverType(CoverType coverType) {this.coverType = coverType;}
    public String getNumberOfPages() {return numberOfPages;}
    public void setNumberOfPages(String numberOfPages) {this.numberOfPages = numberOfPages;}
    public String getISBN_10() {return ISBN_10;}
    public void setISBN_10(String ISBN_10) {this.ISBN_10 = ISBN_10;}
    public String getISBN_13() {return ISBN_13;}
    public void setISBN_13(String ISBN_13) {this.ISBN_13 = ISBN_13;}
    public String getDescription() {return description;}
    public void setDescription(String description) {this.description = description;}
    public Set<AuthorResponse> getAuthors() {return authors;}
    public void setAuthors(Set<AuthorResponse> authors) {this.authors = authors;}
    public PublisherResponse getPublisher() {return publisher;}
    public void setPublisher(PublisherResponse publisher) {this.publisher = publisher;}
    public Set<GenreResponse> getGenres() {return genres;}
    public void setGenres(Set<GenreResponse> genres) {this.genres = genres;}
}
