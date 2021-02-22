package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.domain.UploadForm;
import nl.novi.maas.oliverheldens.demodrop.service.UploadFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/uploadforms")
public class UploadFormController {

    @Autowired
    UploadFormService uploadFormService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllUploadForms() {
        List<UploadForm> uploadForms = uploadFormService.getAllUploadForms();
        return new ResponseEntity<>(uploadForms, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUploadFormById(@PathVariable("id") long id) {
        UploadForm uploadForm = uploadFormService.getUploadFormById(id);
        return new ResponseEntity<>(uploadForm, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteUploadForm(@PathVariable("id") long id) {
        uploadFormService.deleteUploadForm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveUploadForm(@RequestBody UploadForm uploadForm) {
        long newId = uploadFormService.saveUploadForm(uploadForm);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateUploadForm(@PathVariable("id") long id, @RequestBody UploadForm uploadForm) {
        uploadFormService.updateUploadForm(id, uploadForm);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
