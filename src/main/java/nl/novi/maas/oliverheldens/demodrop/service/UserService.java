package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    /**
     * Binnen de applicatie is het (nog) niet mogelijk een user aan te passen
     * Dit wordt in de toekomst wel gedaan, en om deze reden
     * staan deze methodes hier alvast klaar
     */

    List<User> getAllUsers();
    User getUserById(long id);
    void deleteUser(long id);
    long saveUser(User user);
    void updateUser(long id, User user);
    ResponseEntity<?> findUserByToken(String token);
}
