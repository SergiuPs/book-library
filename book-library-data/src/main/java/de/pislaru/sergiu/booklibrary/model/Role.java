package de.pislaru.sergiu.booklibrary.model;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Role extends BaseEntity {

    @Size(min = 6, max = 50)
    private String name;

    @Min(1)
    @Max(99)
    private byte level;

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public byte getLevel() {return level;}
    public void setLevel(byte level) {this.level = level;}
    public Set<Permission> getPermissions() {return permissions;}
    public void setPermissions(Set<Permission> permissions) {this.permissions = permissions;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        Role that = (Role) object;

        return  Objects.equals(this.name, that.name) &&
                Objects.equals(this.level, that.level) &&
                this.permissions.equals(that.permissions);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), name, level, permissions.hashCode());}

    @Override
    public String toString() {
        return "Role {"
                + "name=" + name
                + ", level=" + level
                + ", permissions=" + permissions.toString()
                + "}"
                + super.toString();
    }
}
