package com.accenture.codingtest.springbootcodingtest.service;

import com.accenture.codingtest.springbootcodingtest.entity.User;
import com.accenture.codingtest.springbootcodingtest.model.UserDto;
import com.accenture.codingtest.springbootcodingtest.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    private ModelMapper modelMapper;

    private UUID id;
    @Mock
    private User getUser;

    @Mock
    private UserDto updteUser;

    private UserService userService;

    @Test
    void updateByPartially() {
        modelMapper = new ModelMapper();
        userService = new UserService(userRepository, modelMapper);
        id = UUID.randomUUID();

        when(getUser.getId()).thenReturn(id);
        when(getUser.getUsername()).thenReturn("user1");
        when(getUser.getPassword()).thenReturn("password");

        when(updteUser.getId()).thenReturn(id);
        when(updteUser.getUsername()).thenReturn("user1");
        when(updteUser.getPassword()).thenReturn("newPass");

        when(userRepository.findById(id)).thenReturn(Optional.of(getUser));
        userService.updateByPartially(id, updteUser);

    }
}