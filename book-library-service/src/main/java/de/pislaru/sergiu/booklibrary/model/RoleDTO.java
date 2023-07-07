package de.pislaru.sergiu.booklibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RoleInfo extends BaseEntityInfo implements GrantedAuthority {

    private String name;
    private byte level;
    private Set<PermissionInfo> permissions = new HashSet<>();

    public RoleInfo() {
    }

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public byte getLevel() {return level;}
    public void setLevel(byte level) {this.level = level;}
    public Set<PermissionInfo> getPermissions() {return permissions;}
    public void setPermissions(Set<PermissionInfo> permissions) {this.permissions = permissions;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object .getClass() || !super.equals(object)) {
            return false;
        }

        RoleInfo that = (RoleInfo) object;

        return  Objects.equals(this.name, that.name) &&
                Objects.equals(this.level, that.level) &&
                this.permissions.equals(that.permissions);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), name, level, permissions.hashCode());}

    @Override
    public String toString() {
        return "RoleInfo {"
                + "name=" + name
                + ", level=" + level
                + ", permissionInfos=" + permissions.toString()
                + "}"
                + super.toString();
    }

    @JsonIgnore
    @Override
    public String getAuthority() {
        return this.name;
    }
}
