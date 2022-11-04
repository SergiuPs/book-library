package de.pislaru.sergiu.booklibrary.services;

import de.pislaru.sergiu.booklibrary.model.UserInfo;

import java.util.List;

public interface UserService {
    UserInfo register(UserInfo userInfo);
    UserInfo update(UserInfo userInfo);
    boolean delete(Long id);
    boolean changePassword(Long id, String oldPassword, String newPassword);
    List<UserInfo> getAllUsersWithRoleLevelEqualOrLessThan(byte level);
    boolean userExists(String usernameOrEmail);
}
