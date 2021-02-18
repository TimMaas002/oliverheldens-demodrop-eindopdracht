package nl.novi.maas.oliverheldens.demodrop.payload.request;

public class FeedbackTextRequest {

    private int message_number;
    private String message;

    public int getMessage_number() {
        return message_number;
    }

    public void setMessage_number(int message_number) {
        this.message_number = message_number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
