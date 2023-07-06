package de.pislaru.sergiu.booklibrary.payload.response.user;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RoleResponse implements Serializable {

    private Long id;
    private String name;
    private byte level;
    private Set<PermissionResponse> permissions = new HashSet<>();

    public RoleResponse() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RoleResponse that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name) &&
                Objects.equals(this.level, that.level) &&
                Objects.equals(this.permissions, that.permissions);
    }

    @Override
    public int hashCode() {return Objects.hash(id, name, level, permissions.hashCode());}

    @Override
    public String toString() {
        return "RoleResponse {"
                + "id=" + name
                + ", name=" + name
                + ", level=" + level
                + ", permissions=" + permissions.toString()
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public byte getLevel() {return level;}
    public void setLevel(byte level) {this.level = level;}
    public Set<PermissionResponse> getPermissions() {return permissions;}
    public void setPermissions(Set<PermissionResponse> permissions) {this.permissions = permissions;}
}
