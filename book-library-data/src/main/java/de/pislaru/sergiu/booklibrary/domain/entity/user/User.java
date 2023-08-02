package de.pislaru.sergiu.booklibrary.domain.user;

import de.pislaru.sergiu.booklibrary.domain.BaseEntity;
import de.pislaru.sergiu.booklibrary.domain.address.Address;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.*;

@Entity
public class User extends BaseEntity {

    @Size(min = 3, max = 50)
    private String userName;

    @Email
    private String email;

    @Size(min = 2, max = 100)
    private String firstName;

    @Size(min = 2, max = 100)
    private String lastName;

    @Past
    private LocalDate birthDate;

    @Size(min = 6, max = 255)
    private String avatar;

    @Size(min = 8, max = 255)
    private String password;

    private boolean enabled;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user", targetEntity = Address.class, fetch = FetchType.EAGER)
    @OrderBy
    private Set<Address> addresses = new HashSet<>();

    @ManyToMany(cascade = {
            CascadeType.PERSIST
    }, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"),
    inverseJoinColumns = @JoinColumn(name = "role_id"))
    //@NotEmpty
    private Set<Role> roles = new HashSet<>();

    public User() {
    }

    public User(String firstName, String lastName, String userName, String email, LocalDate birth_date, String avatar,
                String password, boolean enabled, Set<Address> addresses, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.birthDate = birth_date;
        this.avatar = avatar;
        this.password = password;
        this.enabled = enabled;
        this.addresses = addresses;
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User {"
                + super.toString()
                + ", first-name=" + firstName
                + ", last-name=" + lastName
                + ", e-mail=" + email
                + ", birt-date=" + birthDate
                + ", avatar=" + avatar
                + ", user-name=" + userName
                + ", enabled=" + enabled
                + "\n addresses: " + addresses
                + "\n roles: " + roles
                + "}";
    }

    public String getUserName() {return userName;}
    public void setUserName(String userName) {this.userName = userName;}
    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}
    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}
    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}
    public LocalDate getBirthDate() {return birthDate;}
    public void setBirthDate(LocalDate birthDate) {this.birthDate = birthDate;}
    public String getAvatar() {return avatar;}
    public void setAvatar(String avatar) {this.avatar = avatar;}
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
