package de.pislaru.sergiu.booklibrary.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import de.pislaru.sergiu.booklibrary.dto.UserDTO;
import org.springframework.data.domain.Page;

public interface UserService {
    UserDTO update(UserDTO userDTO);
    boolean delete(Long id);
    boolean changePassword(Long id, String oldPassword, String newPassword);
    Page<UserDTO> getAllUsersWithRoleLevelEqualOrLessThan(byte level, Integer pageNo, Integer pageSize, String sortCriteria);
    Page<UserDTO> search(String keyword, Integer pageNo, Integer pageSize);
    boolean userExists(String usernameOrEmail);
    UserDTO getUserById(Long id);

    UserDTO applyPatch(Long id, JsonPatch patch) throws JsonPatchException, JsonProcessingException;
}
