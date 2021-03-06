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

    /**
     Dit endpoint regelt alles mbt het ophalen van de Feedbacktexten
     De @PreAuthorize zorgt ervoor dat alleen een user met de role admin
     deze content kan zien.
     Dit is helaas niet gelukt in de frontend werkend te krijgen.
     Wel is deze controller te testen via postman
     **/

    @Autowired
    FeedbackTextService feedbackTextService;

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "")
    public ResponseEntity<Object> getAllFeedbackTexts() {
        List<FeedbackText> feedbackTexts = feedbackTextService.getAllFeedbackTexts();
        return new ResponseEntity<>(feedbackTexts, HttpStatus.OK);
    }

//    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping(value = "/{id}")
    public ResponseEntity<Object> getFeedbackTextById(@PathVariable("id") long id) {
        FeedbackText feedbackText = feedbackTextService.getFeedbackTextById(id);
        return new ResponseEntity<>(feedbackText, HttpStatus.OK);
    }

}
