package de.pislaru.sergiu.booklibrary.model;

import de.pislaru.sergiu.booklibrary.model.address.AddressInfo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserInfo {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    private String password;

    private Set<RoleInfo> roles = new HashSet<>();

    private Set<AddressInfo> addresses = new HashSet<>();

    public UserInfo() {
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

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

    public Set<RoleInfo> getRoles() {return roles;}

    public void setRoles(Set<RoleInfo> roles) {this.roles = roles;}

    public Set<AddressInfo> getAddresses() {return addresses;}

    public void setAddresses(Set<AddressInfo> addresses) {this.addresses = addresses;}

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        UserInfo user = (UserInfo) object;

        return Objects.equals(id, user.id) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email) &&
                addresses.equals(user.addresses) &&
                roles.equals(user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userName, email, password, addresses, roles);
    }

    @Override
    public String toString() {
        return "UserInfo {"
                + "id=" + id
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + ", e-mail=" + email
                + ", user-name=" + userName
                + ", addresses: " + addresses
                + " roles: " + roles
                + "}";
    }
}
