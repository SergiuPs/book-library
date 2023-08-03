package de.pislaru.sergiu.booklibrary.security.service;

import de.pislaru.sergiu.booklibrary.domain.entity.user.User;
import de.pislaru.sergiu.booklibrary.repository.user.UserRepository;

import de.pislaru.sergiu.booklibrary.security.SecurityUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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

        Optional<User> user = userRepository.findByUsername(usernameOrEmail);

        if (user.isEmpty()) {
            user = userRepository.findByEmail(usernameOrEmail);
        }

        return new SecurityUser(
                user.orElseThrow(() -> new UsernameNotFoundException("No such user with username/email: " + usernameOrEmail))
        );
    }
}
