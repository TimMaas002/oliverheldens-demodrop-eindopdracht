package nl.novi.maas.oliverheldens.demodrop.service;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackText;

import java.util.List;

public interface FeedbackTextService {

    List<FeedbackText> getAllFeedbackTexts();

    FeedbackText getFeedbackTextById(long id);

    void deleteFeedbackText(long id);

    long saveFeedbackText(FeedbackText feedbackText);

    void updateFeedbackText(long id, FeedbackText feedbackText);
}
