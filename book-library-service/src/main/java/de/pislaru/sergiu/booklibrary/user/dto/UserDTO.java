package de.pislaru.sergiu.booklibrary.user.dto;

import de.pislaru.sergiu.booklibrary.address.AddressDTO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserDTO implements Serializable {

    private Long id;
    private Long version;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;
    private Set<RoleDTO> roles = new HashSet<>();
    private Set<AddressDTO> addresses = new HashSet<>();

    public UserDTO() {
    }

    public UserDTO(String firstName, String lastName, String userName, String email, String password, Set<RoleDTO> roles, Set<AddressDTO> addresses) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.userName = userName;
        this.password = password;
        this.roles = roles;
        this.addresses = addresses;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof UserDTO that)) {
            return false;
        }

        return  Objects.equals(this.id, that.id) &&
                Objects.equals(this.version, that.version) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.userName, that.userName) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.addresses, that.addresses) &&
                Objects.equals(this.roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, version, firstName, lastName, userName, email, password, addresses.hashCode(), roles.hashCode());
    }

    @Override
    public String toString() {
        return "UserDTO {"
                + "id" + id
                + ", version=" + version
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + ", e-mail=" + email
                + ", user-name=" + userName
                + ", addresses: " + addresses.toString()
                + " roles: " + roles.toString()
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getVersion() {return version;}
    public void setVersion(Long version) {this.version = version;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Set<RoleDTO> getRoles() {return roles;}
    public void setRoles(Set<RoleDTO> roles) {this.roles = roles;}
    public Set<AddressDTO> getAddresses() {return addresses;}
    public void setAddresses(Set<AddressDTO> addresses) {this.addresses = addresses;}
}
