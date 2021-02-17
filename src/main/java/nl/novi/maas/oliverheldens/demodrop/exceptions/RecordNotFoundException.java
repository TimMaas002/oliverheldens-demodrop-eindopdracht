package nl.novi.maas.oliverheldens.demodrop.exceptions;

public class RecordNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public RecordNotFoundException() {
        super("Cannot find specified record.");
    }

}