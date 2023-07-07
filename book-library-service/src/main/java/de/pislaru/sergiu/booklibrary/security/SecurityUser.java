package de.pislaru.sergiu.booklibrary.model.security;

import de.pislaru.sergiu.booklibrary.model.RoleDTO;
import de.pislaru.sergiu.booklibrary.model.UserDTO;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

public record SecurityUser(UserDTO user, Collection<? extends  GrantedAuthority> authorities) implements UserDetails {

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
        return true;
    }

    /** Get the highest access level from user roles.
     * Will be used for database queries based on roles hierarchy.
     *
     * @return Highest level role if user have roles, else will return 0
     * if user have no roles (bug) and will log the corrupted user
     */
    public byte getHighestRoleLevel() {
        Optional<RoleDTO> roleInfo = user.getRoles().stream().max(Comparator.comparing(RoleDTO::getLevel));

        if (roleInfo.isPresent()) {
            return roleInfo.get().getLevel();
        } else {
            //Log corrupted user
            return 0;
        }
    }
}
