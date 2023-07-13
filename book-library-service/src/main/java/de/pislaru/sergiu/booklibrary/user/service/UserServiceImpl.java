package de.pislaru.sergiu.booklibrary.user.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.fge.jsonpatch.JsonPatch;
import com.github.fge.jsonpatch.JsonPatchException;
import de.pislaru.sergiu.booklibrary.model.user.User;
import de.pislaru.sergiu.booklibrary.user.dto.UserDTO;
import de.pislaru.sergiu.booklibrary.repositories.RoleRepository;
import de.pislaru.sergiu.booklibrary.repositories.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;

    public UserServiceImpl(UserRepository userRepository, ModelMapper modelMapper, RoleRepository roleRepository, ObjectMapper objectMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.roleRepository = roleRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        userRepository.save(modelMapper.map(userDTO, User.class));
        return null;
    }

    @Override
    public boolean delete(Long id) {

        userRepository.deleteById(id);
        return false;
    }

    @PreAuthorize("T(de.pislaru.sergiu.booklibrary.security.SecurityUserHolder).getIdOfLoggedInUser() == #id || hasRole('ADMIN')")
    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public boolean changePassword(Long id, String oldPassword, String newPassword) {
        return false;
    }

    @Override
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public Page<UserDTO> getAllUsersWithRoleLevelEqualOrLessThan(byte level, Integer pageNo, Integer pageSize, String sortCriteria) {
        Pageable paging;

        if (sortCriteria != null && !sortCriteria.isEmpty()) {
            int indexOfSeparator = sortCriteria.indexOf(':');
            String criteria = sortCriteria.substring(0, indexOfSeparator);
            String direction = sortCriteria.substring(indexOfSeparator+1);
            Sort sort;

            if (direction.equals("asc")) {
                sort = Sort.by(criteria).ascending();
            } else {
                sort = Sort.by(criteria).descending();
            }
            paging = PageRequest.of(pageNo, pageSize, sort);

        } else {
            paging = PageRequest.of(pageNo, pageSize);
        }
        Page<User> pagedResult = userRepository.findAll(paging);

        return pagedResult.map(user -> modelMapper.map(user, UserDTO.class));

    }

    @Override
    public Page<UserDTO> search(String keyword, Integer pageNo, Integer pageSize) {
        Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<User> pagedResult = userRepository.search(keyword, paging);
        return pagedResult.map(user -> modelMapper.map(user, UserDTO.class));
    }

    @Override
    public boolean userExists(String usernameOrEmail) {
        return false;
    }

    public UserDTO applyPatch(Long userId, JsonPatch patch) throws JsonPatchException, JsonProcessingException {
        User user = userRepository.findById(userId).get();
        User patchedUser = applyPatchToUser(patch, user);
        User savedUser = userRepository.save(patchedUser);

        return modelMapper.map(savedUser, UserDTO.class);
    }

    private User applyPatchToUser(JsonPatch patch, User targetCustomer) throws JsonPatchException, JsonProcessingException {
        JsonNode node = objectMapper.convertValue(targetCustomer, JsonNode.class);
        JsonNode patched = patch.apply(node);

        return objectMapper.treeToValue(patched, User.class);
    }
}
