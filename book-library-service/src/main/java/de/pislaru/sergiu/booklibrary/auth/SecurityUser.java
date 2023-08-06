package de.pislaru.sergiu.booklibrary.security;

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
    private final boolean accountNonExpired;
    private final boolean accountNonLocked;
    private final boolean credentialsNonExpired;
    private final boolean enabled;
    private final Collection<? extends  GrantedAuthority> authorities;

    public SecurityUser(Long id, String username, String email, String firstName, String lastName, String password,
                        boolean accountNonExpired, boolean accountNonLocked, boolean credentialsNonExpired,
                        boolean enabled, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.accountNonExpired = accountNonExpired;
        this.accountNonLocked = accountNonLocked;
        this.credentialsNonExpired = credentialsNonExpired;
        this.enabled = enabled;
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {return this.authorities;}
    @Override
    public String getPassword() {return password;}
    @Override
    public String getUsername() {return username;}
    @Override
    public boolean isAccountNonExpired() {return accountNonExpired;}
    @Override
    public boolean isAccountNonLocked() {return accountNonLocked;}
    @Override
    public boolean isCredentialsNonExpired() {return credentialsNonExpired;}
    @Override
    public boolean isEnabled() {return enabled;}
    public Long getId() {return id;}
    public String getEmail() {return email;}
    public String getFirstName() {return firstName;}
    public String getLastName() {return lastName;}
}
