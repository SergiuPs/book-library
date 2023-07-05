package de.pislaru.sergiu.booklibrary.commands;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RoleCommand extends BaseEntityCommand {

    @Size(min = 6, max = 50)
    private String name;

    @Min(1)
    @Max(99)
    private byte level;

    private Set<PermissionCommand> permissions = new HashSet<>();

    public RoleCommand() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public byte getLevel() {return level;}
    public void setLevel(byte level) {this.level = level;}
    public Set<PermissionCommand> getPermissions() {return permissions;}
    public void setPermissions(Set<PermissionCommand> permissions) {this.permissions = permissions;}

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        RoleCommand that = (RoleCommand) object;

        return  Objects.equals(this.name, that.name) &&
                Objects.equals(this.level, that.level) &&
                this.permissions.equals(that.permissions);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), name, level, permissions.hashCode());}

    @Override
    public String toString() {
        return "RoleCommand {"
                + "name=" + name
                + ", level=" + level
                + ", permissions=" + permissions.toString()
                + "}"
                + super.toString();
    }
}
