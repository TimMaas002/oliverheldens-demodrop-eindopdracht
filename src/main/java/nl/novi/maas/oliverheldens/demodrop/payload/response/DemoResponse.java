package nl.novi.maas.oliverheldens.demodrop.payload.response;

public class DemoResponse {

    /**
     Deze response wordt aangeroepen wanneer het betrekking heeft op de geuploade demo
     De response is een normale string text
     **/

    private String message;

    public DemoResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}