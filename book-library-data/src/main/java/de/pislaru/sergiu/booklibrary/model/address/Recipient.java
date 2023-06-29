package de.pislaru.sergiu.booklibrary.model.address;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Recipient extends BaseEntity {

    @Enumerated(value = EnumType.STRING)
    @NotNull
    private RecipientTitle title;

    @Size(min = 2, max = 100)
    private String firstName;

    @Size(min = 2, max = 100)
    private String lastName;

    public Recipient() {
    }

    public Recipient(RecipientTitle title, String firstName, String lastName) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public RecipientTitle getTitle() {return title;}
    public void setTitle(RecipientTitle title) {this.title = title;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        Recipient that = (Recipient) object;

        return  Objects.equals(this.title, that.title) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, firstName, lastName);
    }

    @Override
    public String toString() {
        return "Recipient {"
                + "title=" + title.getTitle()
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + "}"
                + super.toString();
    }
}
