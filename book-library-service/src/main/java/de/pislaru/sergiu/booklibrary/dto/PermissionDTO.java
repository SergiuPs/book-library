package de.pislaru.sergiu.booklibrary.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;


public class PermissionDTO implements GrantedAuthority {

    private Long id;
    private String name;

    public PermissionDTO() {
    }
    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PermissionDTO that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {return Objects.hash(id, name);}

    @Override
    public String toString() {
        return "PermissionDTO {"
                + "id=" + id
                + ", name=" + name
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
}
