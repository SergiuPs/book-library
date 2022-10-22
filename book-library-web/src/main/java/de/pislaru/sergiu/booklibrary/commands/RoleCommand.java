package de.pislaru.sergiu.booklibrary.commands;

import java.util.Objects;

public class RoleCommand {

    private Long id;
    private String name;

    public RoleCommand() {
    }

    public RoleCommand(String name) {
        this.name = name;
    }

    public RoleCommand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        RoleCommand role = (RoleCommand) object;

        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "RoleCommand {"
                + "id=" + id
                + ", name=" + name
                + "}";
    }
}
