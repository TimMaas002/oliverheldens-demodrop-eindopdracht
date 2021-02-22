package nl.novi.maas.oliverheldens.demodrop;

import nl.novi.maas.oliverheldens.demodrop.payload.request.FeedbackTextRequest;
import nl.novi.maas.oliverheldens.demodrop.payload.request.SignupRequest;
import nl.novi.maas.oliverheldens.demodrop.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * In deze klasse voegen we twee gebruikers met één rol toe:
 * admin, admin@admin.nl, 123456, ROL: admin
 * user, user@user.nl, 123456, ROL: user
 *
 * UITLEG COMPONENT ANNOTATIE
 * http://zetcode.com/springboot/component/
 */
@Component
public class DatabaseFiller implements CommandLineRunner {

    private final AuthorizationService authorizationService;

    @Autowired
    public DatabaseFiller(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @Override
    public void run(String... args) {

        Set<String> rollen = new HashSet<>();
        rollen.add("admin");

        SignupRequest admin = new SignupRequest();
        admin.setUsername("admin");
        admin.setEmail("admin@admin.nl");
        admin.setPassword("123456");
        admin.setRole(rollen);
        authorizationService.registerUser(admin);

        SignupRequest user = new SignupRequest();
        user.setUsername("user");
        user.setEmail("user@user.nl");
        user.setPassword("123456");
        rollen.remove("admin");
        rollen.add("user");
        user.setRole(rollen);
        authorizationService.registerUser(user);

//        FeedbackTextRequest text_1 = new FeedbackTextRequest();
//        text_1.setMessage("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.");

    }
}