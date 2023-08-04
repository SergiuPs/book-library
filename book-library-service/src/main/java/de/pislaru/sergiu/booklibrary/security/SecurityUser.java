package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.domain.entity.user.Role;
import de.pislaru.sergiu.booklibrary.domain.entity.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;



public final class SecurityUser implements UserDetails {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUser.class);

    private final Collection<? extends  GrantedAuthority> authorities;
    private final User user;

    public SecurityUser(User user) {
        this.user = user;
        this.authorities = getGrantedAuthorities(user.getRoles());
    }

    /**
     * Merge all roles and permissions associated to that role
     * into a Collection of Granted Authorities.
     * @param roles User roles
     * @return User authorities
     */
    private Collection<? extends GrantedAuthority> getGrantedAuthorities(Collection<Role> roles) {
        return roles.stream()
                .flatMap(role -> Stream.concat(
                        Stream.of(new SimpleGrantedAuthority(role.getName())),
                        role.getPermissions().stream()
                                .map(permission -> new SimpleGrantedAuthority(permission.getName()))
                ))
                .collect(Collectors.toList());
    }

    /** Get the highest access level from user roles.
     * Will be used for database queries based on roles hierarchy.
     *
     * @return Highest level role if user have roles, else will return 0
     * if user have no roles (bug) and will log the corrupted user
     */
    public byte getHighestRoleLevel() {
        Optional<Role> roleInfo = user.getRoles().stream().max(Comparator.comparing(Role::getLevel));

        if (roleInfo.isPresent()) {
            return roleInfo.get().getLevel();
        } else {
            logger.error("User without role: {}", user.getId());
            return 0;
        }
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return user.isEnabled();
    }

    @Override
    public boolean isAccountNonLocked() {
        return user.isEnabled();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return user.isEnabled();
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
    }

    public long getId() {
        return user.getId();
    }

    public String getEmail() {
        return user.getEmail();
    }

}
