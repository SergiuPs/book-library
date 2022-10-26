package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.model.Role;
import de.pislaru.sergiu.booklibrary.model.User;
import de.pislaru.sergiu.booklibrary.model.UserInfo;
import de.pislaru.sergiu.booklibrary.model.security.SecurityUser;
import de.pislaru.sergiu.booklibrary.repositories.RoleRepository;
import de.pislaru.sergiu.booklibrary.repositories.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Service;


@Service
public class DatabaseUserDetailsManager implements UserDetailsManager {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    public DatabaseUserDetailsManager(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public void createUser(UserDetails userDetails) {

        SecurityUser securityUser = (SecurityUser) userDetails;
        User user = modelMapper.map(securityUser.user(), User.class);

        if (user.getRoles().size() == 0) {
            Role userRole = roleRepository.getFirstByName(Role.ROLE_USER);
            user.addRole(userRole);
        }

        userRepository.save(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
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
            throw new UsernameNotFoundException("No such user with usernameOrEmail/email: " + usernameOrEmail);
        } else {
            return new SecurityUser(modelMapper.map(user, UserInfo.class));
        }
    }
}
