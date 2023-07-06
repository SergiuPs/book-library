package de.pislaru.sergiu.booklibrary.commands;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RoleCommand implements Serializable {

    private Long id;
    private String name;
    private byte level;
    private Set<PermissionCommand> permissions = new HashSet<>();

    public RoleCommand() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof RoleCommand that)) {
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
    public Set<PermissionCommand> getPermissions() {return permissions;}
    public void setPermissions(Set<PermissionCommand> permissions) {this.permissions = permissions;}
}
