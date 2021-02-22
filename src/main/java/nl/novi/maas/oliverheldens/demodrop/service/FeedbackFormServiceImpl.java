package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackForm;
import nl.novi.maas.oliverheldens.demodrop.exceptions.DatabaseErrorException;
import nl.novi.maas.oliverheldens.demodrop.exceptions.RecordNotFoundException;
import nl.novi.maas.oliverheldens.demodrop.repository.FeedbackFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public void deleteFeedbackForm(long id) {
        if (feedbackFormRepository.existsById(id)) {
            feedbackFormRepository.deleteById(id);
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

    @Override
    public void updateFeedbackForm(long id, FeedbackForm feedbackForm) {
        if (feedbackFormRepository.existsById(id)) {
            try {
                FeedbackForm existingFeedbackForm = feedbackFormRepository.findById(id).orElse(null);
                existingFeedbackForm.setArtist_name(feedbackForm.getArtist_name());
                existingFeedbackForm.setFeedback_message(feedbackForm.getFeedback_message());
                feedbackFormRepository.save(existingFeedbackForm);
            }
            catch (Exception ex) {
                throw new DatabaseErrorException();
            }
        }
        else {
            throw new RecordNotFoundException();
        }
    }
}
