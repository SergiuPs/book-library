package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.model.user.Role;
import de.pislaru.sergiu.booklibrary.model.user.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

public record SecurityUser(User user, Collection<? extends  GrantedAuthority> authorities) implements UserDetails {

    private static final Logger logger = LoggerFactory.getLogger(SecurityUser.class);

    public long id() {
        return user.getId();
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
        return user.getUserName();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return user.isEnabled();
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
}
