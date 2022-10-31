package de.pislaru.sergiu.booklibrary.services;

import de.pislaru.sergiu.booklibrary.model.Role;
import de.pislaru.sergiu.booklibrary.model.User;
import de.pislaru.sergiu.booklibrary.model.UserInfo;
import de.pislaru.sergiu.booklibrary.repositories.RoleRepository;
import de.pislaru.sergiu.booklibrary.repositories.UserRepository;

import de.pislaru.sergiu.booklibrary.utils.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class DatabaseUserService implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;

    public DatabaseUserService(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserInfo register(UserInfo userInfo) {

        User user = modelMapper.map(userInfo, User.class);

        if (user.getRoles().size() == 0) {
            Role userRole = roleRepository.getFirstByName(Role.ROLE_USER);
            user.addRole(userRole);
        }

        userRepository.save(user);
        return null;
    }

    @Override
    public UserInfo update(UserInfo userInfo) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }

    @Override
    public boolean changePassword(Long id, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    public Set<UserInfo> getAllUsersWithRoleLevelEqualOrLessThan(byte level) {
        Set<User> users = userRepository.getAllByRolesLevelLessThanEqual(level);
        Set<UserInfo> userInfos = new HashSet<>();
        ModelMapperUtils.mapSet(users, UserInfo.class, modelMapper);

        return userInfos;
    }

    @Override
    public boolean userExists(String usernameOrEmail) {
        return false;
    }
}
