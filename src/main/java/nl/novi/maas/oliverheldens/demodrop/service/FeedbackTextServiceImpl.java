package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackText;
import nl.novi.maas.oliverheldens.demodrop.exceptions.RecordNotFoundException;
import nl.novi.maas.oliverheldens.demodrop.repository.FeedbackTextRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackTextServiceImpl implements FeedbackTextService {

    /**
     * Deze service geeft alle methodes door aan de repository
     * om de desbetreffende informatie uit de database te halen
     * Mocht deze data niet bekend zijn in de database
     * dan wordt een exception gestuurd
     */

    @Autowired
    FeedbackTextRepository feedbackTextRepository;

    @Override
    public List<FeedbackText> getAllFeedbackTexts() {
        return feedbackTextRepository.findAll();
    }

    @Override
    public FeedbackText getFeedbackTextById(long id) {
        if (feedbackTextRepository.existsById(id)) {
            return feedbackTextRepository.findById(id).orElse(null);
        }
        else {
            throw new RecordNotFoundException();
        }
    }

}
