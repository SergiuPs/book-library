package de.pislaru.sergiu.booklibrary.commands.address;

import de.pislaru.sergiu.booklibrary.commands.BaseEntityCommand;
import de.pislaru.sergiu.booklibrary.model.address.RecipientTitle;
import de.pislaru.sergiu.booklibrary.model.address.Region;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class RecipientCommand extends BaseEntityCommand {

    @NotNull
    private RecipientTitle title;

    @Size(min = 2, max = 100)
    private String firstName;

    @Size(min = 2, max = 100)
    private String lastName;

    public RecipientCommand() {
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

        RecipientCommand that = (RecipientCommand) object;

        return  Objects.equals(this.title, that.title) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), title, firstName, lastName);
    }

    @Override
    public String toString() {
        return "RecipientCommand {"
                + "title=" + title.getTitle()
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + "}"
                + super.toString();
    }
}
