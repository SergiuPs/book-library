package de.pislaru.sergiu.booklibrary.user.dto;

import de.pislaru.sergiu.booklibrary.address.AddressDTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UserDTO implements Serializable {

    private Long id;
    private Long version;
    private String userName;
    private String email;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String avatar;
    private String password;
    private List<RoleDTO> roles = new ArrayList<>();
    private List<AddressDTO> addresses = new ArrayList<>();

    public UserDTO() {
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
                Objects.equals(this.userName, that.userName) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.birthDate, that.birthDate) &&
                Objects.equals(this.avatar, that.avatar) &&
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
                + ", birth-date=" + birthDate
                + ", avatar=" + avatar
                + ", addresses: " + addresses.toString()
                + " roles: " + roles.toString()
                + "}";
    }

    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public Long getVersion() {return version;}
    public void setVersion(Long version) {this.version = version;}
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
    public List<RoleDTO> getRoles() {return roles;}
    public void setRoles(List<RoleDTO> roles) {this.roles = roles;}
    public List<AddressDTO> getAddresses() {return addresses;}
    public void setAddresses(List<AddressDTO> addresses) {this.addresses = addresses;}
}
