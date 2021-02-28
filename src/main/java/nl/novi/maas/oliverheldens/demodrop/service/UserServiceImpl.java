package nl.novi.maas.oliverheldens.demodrop.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import nl.novi.maas.oliverheldens.demodrop.domain.User;
import nl.novi.maas.oliverheldens.demodrop.exceptions.DatabaseErrorException;
import nl.novi.maas.oliverheldens.demodrop.exceptions.RecordNotFoundException;
import nl.novi.maas.oliverheldens.demodrop.payload.response.MessageResponse;
import nl.novi.maas.oliverheldens.demodrop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.xml.bind.DatatypeConverter;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    /**
     * Deze service geeft alle methodes door aan de repository
     * om de desbetreffende informatie uit de database te halen
     * Mocht deze data niet bekend zijn in de database
     * dan wordt een exception gestuurd
     */

    @Value("${novi.sec.jwtSecret}")
    private String jwtSecret;

    @Autowired
    private UserRepository userRepository;

    private static final String PREFIX = "Bearer ";

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        if (userRepository.existsById(id)) {
            return userRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public void deleteUser(long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        }
        else {
            throw new RecordNotFoundException();
        }
    }
    @Override
    public long saveUser(User user) {
        User newUser = userRepository.save(user);
        return newUser.getId();
    }
    @Override
    public void updateUser(long id, User user) {
        if (userRepository.existsById(id)) {
            try {
                User existingUser = userRepository.findById(id).orElse(null);
                existingUser.setUsername(user.getUsername());
                existingUser.setEmail(user.getEmail());
                existingUser.setPassword(user.getPassword());
                userRepository.save(existingUser);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public ResponseEntity<?> findUserByToken(String token) {
        String username = getUsernameFromToken(token);

        if(userExists(username)) {
            return ResponseEntity.ok(findUserByUsername(username));
        }
        return ResponseEntity.badRequest().body(new MessageResponse("User not found"));
    }

    private String getUsernameFromToken(String token) {
        String tokenWithoutBearer = removePrefix(token);

        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecret))
                .parseClaimsJws(tokenWithoutBearer).getBody();

        return claims.getSubject();
    }

    private String removePrefix(String token) {
        return token.replace(PREFIX, "");
    }

    private boolean userExists(String username) {
        return userRepository.existsByUsername(username);
    }

    private User findUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }
}
