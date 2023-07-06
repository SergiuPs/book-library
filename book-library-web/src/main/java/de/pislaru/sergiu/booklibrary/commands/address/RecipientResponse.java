package de.pislaru.sergiu.booklibrary.commands.address;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.model.address.RecipientTitle;
import de.pislaru.sergiu.booklibrary.model.address.Region;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

public class RecipientCommand implements Serializable {

    private Long id;
    private RecipientTitle title;
    private String firstName;
    private String lastName;

    public RecipientCommand() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RecipientCommand that)) {
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
                + "title=" + title.getTitle()
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + "}"
                + super.toString();
    }

    public RecipientTitle getTitle() {return title;}
    public void setTitle(RecipientTitle title) {this.title = title;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
}
