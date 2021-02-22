package nl.novi.maas.oliverheldens.demodrop.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class FeedbackTextRequest {

    @NotBlank
    @Size(max = 100)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
