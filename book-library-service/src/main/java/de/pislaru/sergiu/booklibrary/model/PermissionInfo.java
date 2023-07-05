package de.pislaru.sergiu.booklibrary.model;

import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;


public class PermissionInfo extends BaseEntityInfo implements GrantedAuthority {

    private String name;

    public PermissionInfo() {
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

        PermissionInfo that = (PermissionInfo) object;

        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), name);}

    @Override
    public String toString() {
        return "PermissionInfo {"
                + "name=" + name
                + "}"
                + super.toString();
    }

    @Override
    public String getAuthority() {
        return this.name;
    }
}
