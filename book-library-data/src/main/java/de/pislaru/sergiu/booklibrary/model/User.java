package de.pislaru.sergiu.booklibrary.model;

import de.pislaru.sergiu.booklibrary.model.address.Address;

import javax.persistence.*;
import java.util.*;

@Entity
public class User extends BaseEntity {

    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = Address.class, fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String userName, String email, String password, Set<Address> addresses, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.addresses = addresses;
        this.roles = roles;
    }

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getPassword() {return password;}
    public void setPassword(String password) {this.password = password;}
    public Set<Address> getAddresses() {return addresses;}

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
        for (Address address : this.addresses) {
            address.setUser(this);
        }
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setUser(this);
    }

    public void addRole(Role role) {roles.add(role);}
    public Set<Role> getRoles() {return roles;}
    public void setRoles(Set<Role> roles) {this.roles = roles;}

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        User user = (User) object;

        return  Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(email, user.email) &&
                addresses.equals(user.addresses) &&
                roles.equals(user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, userName, email, password, addresses, roles);
    }

    @Override
    public String toString() {
        return "User {"
                + "first-name=" + firstName
                + ", last-name=" + lastName
                + ", e-mail=" + email
                + ", user-name=" + userName
                + ", addresses: " + addresses
                + " roles: " + roles
                + "}"
                + super.toString();
    }
}
