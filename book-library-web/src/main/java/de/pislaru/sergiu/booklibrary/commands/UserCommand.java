package de.pislaru.sergiu.booklibrary.commands;


import de.pislaru.sergiu.booklibrary.commands.address.AddressCommand;
import de.pislaru.sergiu.booklibrary.commands.address.CityCommand;
import de.pislaru.sergiu.booklibrary.model.address.Region;

import javax.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class UserCommand extends BaseEntityCommand {

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String email;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    private Set<RoleCommand> roles = new HashSet<>();

    private Set<AddressCommand> addresses = new HashSet<>();

    public UserCommand() {
    }

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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public Set<RoleCommand> getRoles() {return roles;}
    public void setRoles(Set<RoleCommand> roles) {
        this.roles = roles;
    }
    public Set<AddressCommand> getAddresses() {return addresses;}
    public void setAddresses(Set<AddressCommand> addresses) {
        this.addresses = addresses;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass() || !super.equals(object)) {
            return false;
        }

        UserCommand user = (UserCommand) object;

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
        return "UserCommand {"
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
