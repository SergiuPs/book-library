package de.pislaru.sergiu.booklibrary.commands;

import de.pislaru.sergiu.booklibrary.commands.address.AddressResponse;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserResponse implements Serializable {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private Set<RoleResponse> roles = new HashSet<>();
    private Set<AddressResponse> addresses = new HashSet<>();

    public UserResponse() {
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof UserResponse that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.userName, that.userName) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.addresses, that.addresses) &&
                Objects.equals(this.roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, userName, email, addresses, roles);
    }

    @Override
    public String toString() {
        return "UserResponse {"
                + "id=" + id
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + ", e-mail=" + email
                + ", user-name=" + userName
                + ", addresses: " + addresses.toString()
                + ", roles: " + roles.toString()
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Set<RoleResponse> getRoles() {return roles;}
    public void setRoles(Set<RoleResponse> roles) {
        this.roles = roles;
    }
    public Set<AddressResponse> getAddresses() {return addresses;}
    public void setAddresses(Set<AddressResponse> addresses) {
        this.addresses = addresses;
    }
}
