package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackForm;
import nl.novi.maas.oliverheldens.demodrop.exceptions.RecordNotFoundException;
import nl.novi.maas.oliverheldens.demodrop.repository.FeedbackFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

    /**
     * Deze service geeft alle methodes door aan de repository
     * om de desbetreffende informatie uit de database te halen
     * Mocht deze data niet bekend zijn in de database
     * dan wordt een exception gestuurd
     */

@Service
public class FeedbackFormServiceImpl implements FeedbackFormService {

    @Autowired
    FeedbackFormRepository feedbackFormRepository;

    @Override
    public List<FeedbackForm> getAllFeedbackForms() {
        return feedbackFormRepository.findAll();
    }

    @Override
    public FeedbackForm getFeedbackFormById(long id) {
        if (feedbackFormRepository.existsById(id)) {
            return feedbackFormRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

    @Override
    public long saveFeedbackForm(FeedbackForm feedbackForm) {
        FeedbackForm newFeedbackForm = feedbackFormRepository.save(feedbackForm);
        return newFeedbackForm.getId();
    }

}
