package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackForm;
import nl.novi.maas.oliverheldens.demodrop.service.FeedbackFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/feedbackforms")
public class FeedbackFormController {

    @Autowired
    FeedbackFormService feedbackFormService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "")
    public ResponseEntity<Object> getAllFeedbackForms() {
        List<FeedbackForm> feedbackForms = feedbackFormService.getAllFeedbackForms();
        return new ResponseEntity<>(feedbackForms, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getFeedbackFormById(@PathVariable("id") long id) {
        FeedbackForm feedbackForm = feedbackFormService.getFeedbackFormById(id);
        return new ResponseEntity<>(feedbackForm, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping(value = "")
    public ResponseEntity<Object> saveFeedbackForm(@RequestBody FeedbackForm feedbackForm) {
        long newId = feedbackFormService.saveFeedbackForm(feedbackForm);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }


}
