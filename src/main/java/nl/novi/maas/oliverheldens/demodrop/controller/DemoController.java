package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/files/uploads")
public class DemoController {

    @Autowired
    DemoService demoService;

    @PostMapping("")
    public void uploadFile(@RequestParam("file") MultipartFile file, Principal principal) throws IllegalStateException, IOException {
        demoService.uploadDemoToDir(file, principal);
    }
}