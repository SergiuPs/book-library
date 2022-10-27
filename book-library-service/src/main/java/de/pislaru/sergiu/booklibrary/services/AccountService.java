package de.pislaru.sergiu.booklibrary.services;

import de.pislaru.sergiu.booklibrary.model.UserInfo;

public interface AccountService {
    UserInfo register(UserInfo userInfo);
    UserInfo update(UserInfo userInfo);
    boolean delete(Long id);
    boolean changePassword(Long id, String oldPassword, String newPassword);
}
