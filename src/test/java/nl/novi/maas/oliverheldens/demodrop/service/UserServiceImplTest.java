//package nl.novi.maas.oliverheldens.demodrop.service;
//
//import nl.novi.maas.oliverheldens.demodrop.OHdemodropApplication;
//import nl.novi.maas.oliverheldens.demodrop.domain.User;
//import nl.novi.maas.oliverheldens.demodrop.repository.UserRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.context.ContextConfiguration;
//import org.mockito.Mockito;
//import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//@SpringBootTest()
//@ContextConfiguration(classes={OHdemodropApplication.class})
//public class UserServiceImplTest {
//
//    @Autowired
//    private UserService userService;
//
//    @MockBean
//    private UserRepository userRepository;
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @Test
//    public void testUpdateUsername() {
//        User tim = new User("tim", "tim.maas@live.nl", "password");
//
//        Mockito
//                .when(userRepository.existsByUsername("tim"))
//                .thenReturn(true);
//
//        assertEquals("tim", tim.getUsername());
//
//    }
//
//}
