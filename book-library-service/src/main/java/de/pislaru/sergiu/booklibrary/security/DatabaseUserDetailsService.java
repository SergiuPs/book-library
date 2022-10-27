package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.model.User;
import de.pislaru.sergiu.booklibrary.model.UserInfo;
import de.pislaru.sergiu.booklibrary.model.security.SecurityUser;
import de.pislaru.sergiu.booklibrary.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public DatabaseUserDetailsService(UserRepository userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }

    /** The user can authenticate himself with an username or email.
     * The method will check the database for a match in both fields.
     *
     * @param usernameOrEmail username or email used for authentication
     * @return UserDetails implementation
     * @throws UsernameNotFoundException if no match in database for username or email
     */
    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {

        User user = userRepository.getFirstByUserName(usernameOrEmail);

        if (user == null) {
            user = userRepository.getFirstByEmail(usernameOrEmail);
        }

        if (user == null) {
            throw new UsernameNotFoundException("No such user with username/email: " + usernameOrEmail);
        } else {
            return new SecurityUser(modelMapper.map(user, UserInfo.class));
        }
    }
}
