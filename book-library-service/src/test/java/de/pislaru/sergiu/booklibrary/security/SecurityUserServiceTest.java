package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.model.user.User;
import de.pislaru.sergiu.booklibrary.user.dto.UserDTO;
import de.pislaru.sergiu.booklibrary.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class SecurityUserServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    SecurityUserService userDetailsService;

    Optional<User> optionalUser;
    UserDTO userDTO;
    SecurityUser securityUser;

    @BeforeEach
    void setUp() {
        User user = new User("Max", "Mustermann", "Maxim", "max@web.de", "pass", true,
                new HashSet<>(), new HashSet<>());
        user.setId(1L);
        optionalUser = Optional.of(user);

        userDTO = new UserDTO("Max", "Mustermann", "Maxim", "max@web.de", "pass",
                new HashSet<>(), new HashSet<>());
        userDTO.setId(1L);

        securityUser = new SecurityUser(user, new ArrayList<>());
    }

    @Test
    void loadUserByUsername() {

        when(userRepository.findByUserName(any())).thenReturn(optionalUser);
        when(modelMapper.map(optionalUser, UserDTO.class)).thenReturn(userDTO);

        UserDetails userDetails = userDetailsService.loadUserByUsername("Maxim");

        verify(userRepository, times(1)).findByUserName(any());
        verify(userRepository, times(0)).findByEmail(any());
        assertEquals(userDetails, securityUser);
        assertEquals("Maxim", securityUser.user().getUserName());
    }

    @Test
    void loadUserByEmail() {

        when(userRepository.findByUserName(any())).thenReturn(null);
        when(userRepository.findByEmail(any())).thenReturn(optionalUser);
        when(modelMapper.map(optionalUser, UserDTO.class)).thenReturn(userDTO);

        UserDetails userDetails = userDetailsService.loadUserByUsername("max@web.de");

        verify(userRepository, times(1)).findByUserName(any());
        verify(userRepository, times(1)).findByEmail(any());
        assertEquals(userDetails, securityUser);
        assertEquals("max@web.de", securityUser.user().getEmail());
    }

    @Test
    void loadUserByUsernameThrowsException() {

        when(userRepository.findByUserName(any())).thenReturn(null);
        when(userRepository.findByEmail(any())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("Unknown");
        });

        verify(userRepository, times(1)).findByUserName(any());
        verify(userRepository, times(1)).findByEmail(any());

    }
}