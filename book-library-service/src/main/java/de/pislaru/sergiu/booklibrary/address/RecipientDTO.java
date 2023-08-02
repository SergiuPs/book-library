package de.pislaru.sergiu.booklibrary.address;

import de.pislaru.sergiu.booklibrary.domain.entity.address.RecipientTitle;

import java.util.Objects;

public class RecipientDTO {

    private Long id;
    private Long version;
    private RecipientTitle title;
    private String firstName;
    private String lastName;

    public RecipientDTO() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RecipientDTO that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.version, that.version) &&
                Objects.equals(this.title, that.title) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, title, firstName, lastName);
    }

    @Override
    public String toString() {
        return "RecipientDTO {"
                + "id=" + id
                + ", version=" + version
                + ", title=" + title.getValue()
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getVersion() {return version;}
    public void setVersion(Long version) {this.version = version;}
    public RecipientTitle getTitle() {return title;}
    public void setTitle(RecipientTitle title) {this.title = title;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
}
