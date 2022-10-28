package de.pislaru.sergiu.booklibrary.security;

import de.pislaru.sergiu.booklibrary.model.User;
import de.pislaru.sergiu.booklibrary.model.UserInfo;
import de.pislaru.sergiu.booklibrary.model.security.SecurityUser;
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

import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class DatabaseUserDetailsServiceTest {

    @Mock
    UserRepository userRepository;

    @Mock
    ModelMapper modelMapper;

    @InjectMocks
    DatabaseUserDetailsService userDetailsService;

    User user;
    UserInfo userInfo;
    SecurityUser securityUser;

    @BeforeEach
    void setUp() {
        user = new User("Max", "Mustermann", "Maxim", "max@web.de", "pass",
                new HashSet<>(), new HashSet<>());
        user.setId(1L);

        userInfo = new UserInfo("Max", "Mustermann", "Maxim", "max@web.de", "pass",
                new HashSet<>(), new HashSet<>());
        userInfo.setId(1L);

        securityUser = new SecurityUser(userInfo);
    }

    @Test
    void loadUserByUsername() {

        when(userRepository.getFirstByUserName(any())).thenReturn(user);
        when(modelMapper.map(user, UserInfo.class)).thenReturn(userInfo);

        UserDetails userDetails = userDetailsService.loadUserByUsername("Maxim");

        verify(userRepository, times(1)).getFirstByUserName(any());
        verify(userRepository, times(0)).getFirstByEmail(any());
        assertEquals(userDetails, securityUser);
        assertEquals("Maxim", securityUser.user().getUserName());
    }

    @Test
    void loadUserByEmail() {

        when(userRepository.getFirstByUserName(any())).thenReturn(null);
        when(userRepository.getFirstByEmail(any())).thenReturn(user);
        when(modelMapper.map(user, UserInfo.class)).thenReturn(userInfo);

        UserDetails userDetails = userDetailsService.loadUserByUsername("max@web.de");

        verify(userRepository, times(1)).getFirstByUserName(any());
        verify(userRepository, times(1)).getFirstByEmail(any());
        assertEquals(userDetails, securityUser);
        assertEquals("max@web.de", securityUser.user().getEmail());
    }

    @Test
    void loadUserByUsernameThrowsException() {

        when(userRepository.getFirstByUserName(any())).thenReturn(null);
        when(userRepository.getFirstByEmail(any())).thenReturn(null);

        assertThrows(UsernameNotFoundException.class, () -> {
            userDetailsService.loadUserByUsername("Unknown");
        });

        verify(userRepository, times(1)).getFirstByUserName(any());
        verify(userRepository, times(1)).getFirstByEmail(any());

    }
}