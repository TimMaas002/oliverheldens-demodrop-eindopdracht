package nl.novi.maas.oliverheldens.demodrop.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "feedback_text")
public class FeedbackText {

    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "native"
    )
    @GenericGenerator(
            name = "native",
            strategy = "native"
    )
    @Column(columnDefinition = "serial")
    private long id;
    private int message_number;
    private String message;

    public FeedbackText() {

    }

    public FeedbackText(int message_number, String message) {
        this.message_number = message_number;
        this.message = message;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMessage_number() {
        return message_number;
    }

    public void setMessage_number(int message_number) {
        this.message_number = message_number;
    }
}
