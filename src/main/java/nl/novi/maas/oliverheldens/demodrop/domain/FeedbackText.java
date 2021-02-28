package nl.novi.maas.oliverheldens.demodrop.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "feedback_text")
public class FeedbackText {

    /**
     Middels dit domain kunnen de feedbacktexten
     geplaatst worden in de database met elk zijn eigen id
     **/

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
    private String message;

    public FeedbackText() {

    }

    public FeedbackText(String message) {
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

}
