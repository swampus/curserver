package com.cur.apps.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.cur.apps.database.NoSQLDatabaseService;
import com.cur.apps.dto.UserDTO;
import com.cur.apps.dto.mapper.UserMapper;
import com.cur.apps.model.v1.User;
import com.cur.apps.repository.UserRepository;
import com.cur.apps.service.validator.UserValidator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private NoSQLDatabaseService noSQLDatabaseService = mock(NoSQLDatabaseService.class);

    UserService userService = new UserService(userRepository,
            new UserMapper(),
            new UserValidator(), new ObjectMapper(), noSQLDatabaseService);


    @Test
    public void getUserByIdTest(){
        User user = new User();
        user.setSurname("S1");
        user.setUserPk("USERPK");


        when(userRepository.getOne(100L)).thenReturn(user);
        UserDTO userResult = userService.getUserById(100L);

        assertEquals("S1", userResult.getSurname());

    }

}