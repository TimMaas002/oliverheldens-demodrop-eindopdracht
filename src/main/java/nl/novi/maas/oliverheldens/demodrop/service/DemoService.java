package nl.novi.maas.oliverheldens.demodrop.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;

public interface DemoService {
    public void uploadDemoToDir(MultipartFile file, Principal principal, String name, String email, String message) throws IOException;

}