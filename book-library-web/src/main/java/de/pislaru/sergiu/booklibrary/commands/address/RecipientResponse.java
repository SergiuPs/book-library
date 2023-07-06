package de.pislaru.sergiu.booklibrary.commands.address;

import de.pislaru.sergiu.booklibrary.model.address.RecipientTitle;
import java.io.Serializable;
import java.util.Objects;

public class RecipientResponse implements Serializable {

    private Long id;
    private RecipientTitle title;
    private String firstName;
    private String lastName;

    public RecipientResponse() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RecipientResponse that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.title, that.title) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, firstName, lastName);
    }

    @Override
    public String toString() {
        return "RecipientResponse {"
                + "id=" + id
                + ", title=" + title.getTitle()
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public RecipientTitle getTitle() {return title;}
    public void setTitle(RecipientTitle title) {this.title = title;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
}
