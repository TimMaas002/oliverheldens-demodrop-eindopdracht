package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackForm;
import nl.novi.maas.oliverheldens.demodrop.service.FeedbackFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/feedbackforms")
public class FeedbackFormController {

    @Autowired
    FeedbackFormService feedbackFormService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllFeedbackForms() {
        List<FeedbackForm> feedbackForms = feedbackFormService.getAllFeedbackForms();
        return new ResponseEntity<>(feedbackForms, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getUploadFormById(@PathVariable("id") long id) {
        FeedbackForm feedbackForm = feedbackFormService.getFeedbackFormById(id);
        return new ResponseEntity<>(feedbackForm, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteFeedbackForm(@PathVariable("id") long id) {
        feedbackFormService.deleteFeedbackForm(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveFeedbackForm(@RequestBody FeedbackForm feedbackForm) {
        long newId = feedbackFormService.saveFeedbackForm(feedbackForm);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateFeedbackForm(@PathVariable("id") long id, @RequestBody FeedbackForm feedbackForm) {
        feedbackFormService.updateFeedbackForm(id, feedbackForm);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
