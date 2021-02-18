package nl.novi.maas.oliverheldens.demodrop.repository;

import nl.novi.maas.oliverheldens.demodrop.domain.FeedbackText;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FeedbackTextRepository extends JpaRepository<FeedbackText, Long> {

    Optional<FeedbackText> findByFeedbackTextId(long feedbackTextId);
}
