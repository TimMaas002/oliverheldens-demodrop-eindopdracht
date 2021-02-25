package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.domain.UploadData;
import nl.novi.maas.oliverheldens.demodrop.service.UploadDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/uploadforms")
public class UploadDataController {

    @Autowired
    UploadDataService uploadDataService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllUploads() {
        List<UploadData> uploads = uploadDataService.getAllUploadDatas();
        return new ResponseEntity<>(uploads, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUploadById(@PathVariable("id") long id) {
        UploadData upload = uploadDataService.getUploadById(id);
        return new ResponseEntity<>(upload, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUpload(@PathVariable("id") long id) {
        uploadDataService.deleteUpload(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveUpload(@RequestBody UploadData upload, Principal principal,
                                             @RequestParam("file") MultipartFile file,
                                             @RequestParam("name") String name,
                                             @RequestParam("email") String email,
                                             @RequestParam("songName") String songName,
                                             @RequestParam("message") String message) throws IOException {
        long newId = uploadDataService.createUpload(upload, principal, file, name, email, songName, message);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUpload(@PathVariable("id") long id, @RequestBody UploadData upload) {
        uploadDataService.updateUpload(id, upload);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
