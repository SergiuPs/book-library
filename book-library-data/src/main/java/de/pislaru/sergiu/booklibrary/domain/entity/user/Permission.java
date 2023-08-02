package de.pislaru.sergiu.booklibrary.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.pislaru.sergiu.booklibrary.domain.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Size;
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
    public String toString() {
        return "Permission { "
                + super.toString()
                + ", name=" + name
                + "}";
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public Set<Role> getRoles() {return roles;}
    public void setRoles(Set<Role> roles) {this.roles = roles;}
}
