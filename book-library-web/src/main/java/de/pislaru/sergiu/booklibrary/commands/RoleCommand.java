package de.pislaru.sergiu.booklibrary.commands;

import java.util.Objects;

public class RoleCommand extends BaseEntityCommand {

    private String name;
    private String level;

    public RoleCommand() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public String getLevel() {return level;}
    public void setLevel(String level) {this.level = level;}

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        RoleCommand role = (RoleCommand) object;

        return  Objects.equals(name, role.name) &&
                Objects.equals(level, role.level);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), name, level);}

    @Override
    public String toString() {
        return "RoleCommand {"
                + "name=" + name
                + ", level=" + level
                + "}"
                + super.toString();
    }
}
