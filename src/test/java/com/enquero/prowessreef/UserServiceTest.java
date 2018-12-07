package com.enquero.prowessreef;

import com.enquero.prowessreef.model.User;
import com.enquero.prowessreef.repository.UserRepository;
import com.enquero.prowessreef.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {


    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;


    @Test
    public void  testSave(){
        User user = new User();
        userService.createUser(user);

    }

}
