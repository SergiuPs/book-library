package de.pislaru.sergiu.booklibrary.model;

import org.springframework.security.core.GrantedAuthority;
import java.util.Objects;

public class RoleInfo extends BaseEntityInfo implements GrantedAuthority {

    private String name;
    private byte level;

    public RoleInfo() {
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

        RoleInfo role = (RoleInfo) object;

        return  Objects.equals(name, role.name) &&
                Objects.equals(level, role.level);
    }

    @Override
    public int hashCode() {return Objects.hash(super.hashCode(), name, level);}

    @Override
    public String toString() {
        return "RoleInfo {"
                + "name=" + name
                + ", level=" + level
                + "}"
                + super.toString();
    }

    @Override
    public String getAuthority() {
        return name;
    }
}
