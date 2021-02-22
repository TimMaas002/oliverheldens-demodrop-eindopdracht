package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackForm;

import java.util.List;

public interface FeedbackFormService {

    List<FeedbackForm> getAllFeedbackForms();

    FeedbackForm getFeedbackFormById(long id);

    void deleteFeedbackForm(long id);

    long saveFeedbackForm(FeedbackForm feedbackForm);

    void updateFeedbackForm(long id, FeedbackForm feedbackForm);
}
