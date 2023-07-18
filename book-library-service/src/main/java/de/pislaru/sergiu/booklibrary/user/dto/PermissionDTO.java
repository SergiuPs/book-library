package de.pislaru.sergiu.booklibrary.user.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import java.util.Objects;


public class PermissionDTO implements GrantedAuthority {

    private Long id;
    private Long version;
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
                Objects.equals(this.version, that.version) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {return Objects.hash(id, version, name);}

    @Override
    public String toString() {
        return "PermissionDTO {"
                + "id=" + id
                + ", version=" + version
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
    public Long getVersion() {return version;}
    public void setVersion(Long version) {this.version = version;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
