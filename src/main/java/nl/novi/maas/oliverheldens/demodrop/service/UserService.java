package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    User getUserById(long id);
    void deleteUser(long id);
    long saveUser(User user);
    void updateUser(long id, User user);
}
