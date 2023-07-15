package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.model.user.Permission;
import de.pislaru.sergiu.booklibrary.model.user.Role;
import de.pislaru.sergiu.booklibrary.model.user.User;
import de.pislaru.sergiu.booklibrary.repositories.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;


@Service
public class SecurityUserService implements UserDetailsService {

    private final UserRepository userRepository;

    public SecurityUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /** The user can authenticate himself with a username or email.
     * The method will check the database for a match in both fields.
     *
     * @param usernameOrEmail username or email used for authentication
     * @return UserDetails implementation
     * @throws UsernameNotFoundException if no match in database for username or email
     */
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        Optional<User> user = userRepository.findByUserName(usernameOrEmail);

        if (user.isEmpty()) {
            user = userRepository.findByEmail(usernameOrEmail);
        }

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("No such user with username/email: " + usernameOrEmail);
        } else {
            return new SecurityUser(user.get(), getAuthorities(user.get().getRoles()));
        }
    }

    private Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        return getGrantedAuthorities(getPermissionsAndRoles(roles));
    }

    private List<String> getPermissionsAndRoles(Collection<Role> roles) {
        List<String> permissionsAndRoles = new ArrayList<>();
        List<Permission> permissions = new ArrayList<>();

        for (Role role : roles) {
            permissionsAndRoles.add(role.getName());
            permissions.addAll(role.getPermissions());
        }

        for (Permission item : permissions) {
            permissionsAndRoles.add(item.getName());
        }

        return permissionsAndRoles;
    }

    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (String privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege));
        }
        return authorities;
    }
}
