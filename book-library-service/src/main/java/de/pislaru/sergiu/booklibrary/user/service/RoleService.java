package de.pislaru.sergiu.booklibrary.user.service;

import de.pislaru.sergiu.booklibrary.dto.RoleDTO;

import java.util.Set;

public interface RoleService {
    Set<RoleDTO> getRoles();
}
