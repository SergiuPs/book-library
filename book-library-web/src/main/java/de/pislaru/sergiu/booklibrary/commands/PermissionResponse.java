package de.pislaru.sergiu.booklibrary.commands;

import javax.validation.constraints.Size;
import java.util.Objects;

public class PermissionCommand extends BaseEntityCommand {

    @Size(min = 3, max = 50)
    private String name;

    public PermissionCommand() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        PermissionCommand that = (PermissionCommand) object;

        return  Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), name);}

    @Override
    public String toString() {
        return "PermissionCommand {"
                + "name=" + name
                + "}"
                + super.toString();
    }
}
