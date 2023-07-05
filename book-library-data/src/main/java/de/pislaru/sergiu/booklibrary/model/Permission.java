package de.pislaru.sergiu.booklibrary.model;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
public class Permission extends BaseEntity {

    @Size(min = 3, max = 50)
    private String name;

    @ManyToMany(mappedBy = "permissions")
    Set<Role> roles;

    public Permission() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Set<Role> getRoles() {return roles;}
    public void setRoles(Set<Role> roles) {this.roles = roles;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        Permission that = (Permission) object;

        return Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), name);}

    @Override
    public String toString() {
        return "Permission {"
                + "name=" + name
                + "}"
                + super.toString();
    }
}
