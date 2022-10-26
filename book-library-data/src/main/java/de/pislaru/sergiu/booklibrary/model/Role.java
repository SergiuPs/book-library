package de.pislaru.sergiu.booklibrary.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Role extends BaseEntity {

    public static final String ROLE_SUPER_ADMIN = "ROLE_SUPER_ADMIN";
    public static final String ROLE_ADMIN = "ROLE_ADMIN";
    public static final String ROLE_LIBRARY_MANAGER = "ROLE_LIBRARY_MANAGER";
    public static final String ROLE_LIBRARIAN= "ROLE_LIBRARIAN";
    public static final String ROLE_USER = "ROLE_USER";

    private String name;
    private byte level;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Role() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public byte getLevel() {return level;}
    public void setLevel(byte level) {this.level = level;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        Role role = (Role) object;

        return  Objects.equals(name, role.name) &&
                Objects.equals(level, role.level);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), name, level);}

    @Override
    public String toString() {
        return "Role {"
                + "name=" + name
                + ", level=" + level
                + "}"
                + super.toString();
    }
}
