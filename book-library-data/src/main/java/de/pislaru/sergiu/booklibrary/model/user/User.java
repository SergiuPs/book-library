package de.pislaru.sergiu.booklibrary.model.user;

import de.pislaru.sergiu.booklibrary.model.BaseEntity;
import de.pislaru.sergiu.booklibrary.model.address.Address;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.*;

@Entity
public class User extends BaseEntity {

    @Size(min = 2, max = 100)
    private String firstName;

    @Size(min = 2, max = 100)
    private String lastName;

    @Size(min = 3, max = 50)
    private String userName;

    @Email
    private String email;

    @Size(min = 8, max = 255)
    private String password;

    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = Address.class, fetch = FetchType.EAGER)
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    @NotEmpty
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String userName, String email, String password,
                boolean enabled, Set<Address> addresses, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.enabled = enabled;
        this.addresses = addresses;
        this.roles = roles;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof User that)) {
            return false;
        }

        return  Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.userName, that.userName) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.password, that.password) &&
                this.enabled == that.enabled &&
                Objects.equals(this.addresses, that.addresses) &&
                Objects.equals(this.roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, userName, email, password, enabled, addresses, roles);
    }

    @Override
    public String toString() {
        return "User {"
                + "first-name=" + firstName
                + ", last-name=" + lastName
                + ", e-mail=" + email
                + ", user-name=" + userName
                + ", enabled=" + enabled
                + ", addresses: " + addresses
                + " roles: " + roles
                + "}"
                + super.toString();
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
    public boolean isEnabled() {return enabled;}
    public void setEnabled(boolean enabled) {this.enabled = enabled;}
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
}
