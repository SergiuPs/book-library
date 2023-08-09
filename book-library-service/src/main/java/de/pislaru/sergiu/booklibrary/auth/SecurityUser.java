package de.pislaru.sergiu.booklibrary.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public final class SecurityUser implements UserDetails {

    private final Long id;
    private final String username;
    private final String email;
    private final String firstName;
    private final String lastName;
    private final String password;
    private final boolean enabled;
    private final Collection<? extends  GrantedAuthority> authorities;

    public SecurityUser(Long id, String username, String email, String firstName, String lastName, String password,
                        boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof SecurityUser that)) {
            return false;
        }

        return this.id != null && this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return this.id.hashCode();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName()+ " {" +
                "Id=" + this.id + ", " +
                "Username=" + this.username + ", " +
                "Email=" + this.email + ", " +
                "FirstName=" + this.firstName + ", " +
                "LastName=" + this.lastName + ", " +
                "Password=[***********], " +
                "Enabled=" + this.enabled + ", " +
                "Authorities=" + this.authorities.toString() + "}";
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return this.authorities;}
    @Override
    public String getPassword() {return password;}
    @Override
    public String getUsername() {return username;}
    @Override
    public boolean isAccountNonExpired() {return enabled;}
    @Override
    public boolean isAccountNonLocked() {return enabled;}
    @Override
    public boolean isCredentialsNonExpired() {return enabled;}
    @Override
    public boolean isEnabled() {return enabled;}
    public Long getId() {return id;}
    public String getEmail() {return email;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}

}
