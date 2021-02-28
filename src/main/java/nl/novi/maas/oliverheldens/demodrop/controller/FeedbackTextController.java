package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackText;
import nl.novi.maas.oliverheldens.demodrop.service.FeedbackTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/feedbacktexts")
public class FeedbackTextController {

    @Autowired
    FeedbackTextService feedbackTextService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(value = "")
    public ResponseEntity<Object> getAllFeedbackTexts() {
        List<FeedbackText> feedbackTexts = feedbackTextService.getAllFeedbackTexts();
        return new ResponseEntity<>(feedbackTexts, HttpStatus.OK);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getFeedbackTextById(@PathVariable("id") long id) {
        FeedbackText feedbackText = feedbackTextService.getFeedbackTextById(id);
        return new ResponseEntity<>(feedbackText, HttpStatus.OK);
    }

}
