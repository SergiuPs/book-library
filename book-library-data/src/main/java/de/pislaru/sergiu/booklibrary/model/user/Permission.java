package de.pislaru.sergiu.booklibrary.model.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.pislaru.sergiu.booklibrary.model.BaseEntity;

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
    @JsonIgnore
    Set<Role> roles;

    public Permission() {
    }

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

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Set<Role> getRoles() {return roles;}
    public void setRoles(Set<Role> roles) {this.roles = roles;}
}