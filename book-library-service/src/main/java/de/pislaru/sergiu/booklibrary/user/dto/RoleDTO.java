package de.pislaru.sergiu.booklibrary.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RoleDTO implements GrantedAuthority, Serializable {

    private Long id;
    private String name;
    private byte level;
    private Set<PermissionDTO> permissions = new HashSet<>();

    public RoleDTO() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RoleDTO that)) {
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
        return "RoleDTO {"
                + "id=" + id
                + ", name=" + name
                + ", level=" + level
                + ", permissionInfos=" + permissions.toString()
                + "}";
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return this.name;
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public byte getLevel() {return level;}
    public void setLevel(byte level) {this.level = level;}
    public Set<PermissionDTO> getPermissions() {return permissions;}
    public void setPermissions(Set<PermissionDTO> permissions) {this.permissions = permissions;}
}
