package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.OHdemodropApplication;
import nl.novi.maas.oliverheldens.demodrop.domain.Roles;
import nl.novi.maas.oliverheldens.demodrop.domain.User;
import nl.novi.maas.oliverheldens.demodrop.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;

@ExtendWith(SpringExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userServiceImpl;

    @Mock
    UserRepository userRepository;

    @Mock
    User user;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
        user = new User();
        user.setId(3);
        user.setUsername("timheee");
        user.setEmail("tim.maas@live.nl");
        user.setPassword("password");

        user = new User();
        user.setId(4);
        user.setUsername("koen");
        user.setEmail("koen.maas@live.nl");
        user.setPassword("password");

    }

    @Test
    public void testWhenFindByIdShouldReturnUsername() {

        Mockito
                .when(userRepository.existsById((long) 3))
                .thenReturn(true);

        Mockito
                .when(userRepository.findById((long) 3))
                .thenReturn(Optional.of(user));

        Assertions.assertEquals(userServiceImpl.getUserById(3).getUsername(), user.getUsername());

    }

    @Test
    public void testWhenFindByIdNotFoundShouldReturn404() {

        Mockito
                .when(userRepository.existsById((long) 4))
                .thenReturn(true);

        Mockito
                .when(userRepository.existsById((long) 5))
                .thenReturn(false);

        Mockito
                .when(userRepository.findById((long) 5))
                .thenReturn(null);

        User noUser = userServiceImpl.getUserById(user.getId());

        Assertions.assertNull(noUser, "This gives a 404");

    }

}
