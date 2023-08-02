package de.pislaru.sergiu.booklibrary.domain.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.pislaru.sergiu.booklibrary.domain.BaseEntity;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
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
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "role_permission",
    joinColumns = @JoinColumn(name = "role_id"),
    inverseJoinColumns = @JoinColumn(name = "permission_id"))
    private Set<Permission> permissions;

    @ManyToMany(mappedBy = "roles")
    @JsonIgnore
    private Set<User> users;

    public Role() {
    }

    @Override
    public String toString() {
        return "Role { "
                + super.toString()
                + ", name=" + name
                + ", level=" + level
                + ", permissions=" + permissions.toString()
                + "}";
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public byte getLevel() {return level;}
    public void setLevel(byte level) {this.level = level;}
    public Set<Permission> getPermissions() {return permissions;}
    public void setPermissions(Set<Permission> permissions) {this.permissions = permissions;}
    public Set<User> getUsers() {return users;}
    public void setUsers(Set<User> users) {this.users = users;}
}
