package de.pislaru.sergiu.booklibrary.model;

import java.util.Objects;

public class RoleInfo {

    private Long id;
    private String name;

    public RoleInfo() {
    }

    public RoleInfo(Long id, String name) {
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        RoleInfo role = (RoleInfo) object;

        return Objects.equals(id, role.id) &&
                Objects.equals(name, role.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "RoleInfo {"
                + "id=" + id
                + ", name=" + name
                + "}";
    }
}
