package nl.novi.maas.oliverheldens.demodrop.controller;

import nl.novi.maas.oliverheldens.demodrop.service.FeedbackFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/feedback_forms")
public class FeedbackFormController {

    @Autowired
    FeedbackFormService feedbackFormService;

}
