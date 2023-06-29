package de.pislaru.sergiu.booklibrary.model.address;

import de.pislaru.sergiu.booklibrary.model.BaseEntityInfo;

import java.util.Objects;

public class RecipientInfo extends BaseEntityInfo {

    private RecipientTitle title;
    private String firstName;
    private String lastName;

    public RecipientInfo() {
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

        RecipientInfo that = (RecipientInfo) object;

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
        return "RecipientInfo {"
                + "title=" + title.getTitle()
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + "}"
                + super.toString();
    }
}
