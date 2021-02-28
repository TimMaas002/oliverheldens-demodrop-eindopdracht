package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.Demo;
import nl.novi.maas.oliverheldens.demodrop.domain.User;
import nl.novi.maas.oliverheldens.demodrop.repository.DemoRepository;
import nl.novi.maas.oliverheldens.demodrop.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.util.Optional;

@Service
public class DemoServiceImpl implements DemoService{

    /**
     * Deze implementatie geeft aan naar welke map de file moet worden geüpload
     * Daarnaast wordt de juiste informatie als name & message geplaatst in
     * de juiste kolom
     */

    @Autowired
    private DemoRepository demoRepository;

    @Autowired
    private UserRepository userRepository;

    public static String uploadDir = System.getProperty("user.dir") + "/fileUploads/";

    @Override
    public void uploadDemoToDir(MultipartFile file, Principal principal,String name, String email, String message) throws IOException {
        file.transferTo(new File(uploadDir + file.getOriginalFilename()));

        long currentUserId = ((UserDetailsImpl) ((UsernamePasswordAuthenticationToken) principal).getPrincipal()).getId();
        Optional<User> optionalUser = userRepository.findById(currentUserId);

        Demo demo = new Demo();

        demo.setName(name);
        demo.setEmail(email);
        demo.setDemo(file.getOriginalFilename());
        demo.setMessage(message);
        demo.setUser(optionalUser.get());

        demoRepository.save(demo).getId();
    }

}