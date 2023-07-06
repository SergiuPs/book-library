package de.pislaru.sergiu.booklibrary.commands;

import java.io.Serializable;
import java.util.Objects;

public class PermissionResponse implements Serializable {

    private Long id;
    private String name;

    public PermissionResponse() {
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof PermissionResponse that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.name, that.name);
    }

    @Override
    public int hashCode() {return Objects.hash(id, name);}

    @Override
    public String toString() {
        return "PermissionCommand {"
                + "id=" + id
                + ", name=" + name
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
}
