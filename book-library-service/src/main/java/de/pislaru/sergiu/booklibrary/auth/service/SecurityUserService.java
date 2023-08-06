package de.pislaru.sergiu.booklibrary.security.service;

import de.pislaru.sergiu.booklibrary.domain.entity.user.Role;
import de.pislaru.sergiu.booklibrary.domain.entity.user.User;
import de.pislaru.sergiu.booklibrary.repository.user.UserRepository;

import de.pislaru.sergiu.booklibrary.security.SecurityUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        Optional<User> optionalUser = userRepository.findByUsername(usernameOrEmail);

        if (optionalUser.isEmpty()) {
            optionalUser = userRepository.findByEmail(usernameOrEmail);
        }

        User user = optionalUser.orElseThrow(() -> new UsernameNotFoundException("No such user with username/email: " + usernameOrEmail));

        return new SecurityUser(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.isEnabled(),
                user.isEnabled(),
                user.isEnabled(),
                user.isEnabled(),
                getGrantedAuthorities(user.getRoles())
        );
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

}
