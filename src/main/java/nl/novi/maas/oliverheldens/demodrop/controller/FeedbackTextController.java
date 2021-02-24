package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackText;
import nl.novi.maas.oliverheldens.demodrop.service.FeedbackTextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/feedbacktexts")
public class FeedbackTextController {

    @Autowired
    FeedbackTextService feedbackTextService;

    @GetMapping(value = "")
    public ResponseEntity<Object> getAllFeedbackTexts() {
        List<FeedbackText> feedbackTexts = feedbackTextService.getAllFeedbackTexts();
        return new ResponseEntity<>(feedbackTexts, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getFeedbackTextById(@PathVariable("id") long id) {
        FeedbackText feedbackText = feedbackTextService.getFeedbackTextById(id);
        return new ResponseEntity<>(feedbackText, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Object> deleteFeedbackText(@PathVariable("id") long id) {
        feedbackTextService.deleteFeedbackText(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping(value = "")
    public ResponseEntity<Object> saveFeedbackText(@RequestBody FeedbackText feedbackText) {
        long newId = feedbackTextService.saveFeedbackText(feedbackText);
        return new ResponseEntity<>(newId, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Object> updateFeedbackText(@PathVariable("id") long id, @RequestBody FeedbackText feedbackText) {
        feedbackTextService.updateFeedbackText(id, feedbackText);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
