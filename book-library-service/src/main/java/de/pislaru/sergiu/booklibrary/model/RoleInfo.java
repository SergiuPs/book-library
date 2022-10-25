package de.pislaru.sergiu.booklibrary.model;

import java.util.Objects;

public class RoleInfo extends BaseEntityInfo {

    private String name;

    public RoleInfo() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        RoleInfo role = (RoleInfo) object;

        return Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(),name);
    }

    @Override
    public String toString() {
        return "RoleInfo {"
                + ", name=" + name
                + "}"
                + super.toString();
    }
}
