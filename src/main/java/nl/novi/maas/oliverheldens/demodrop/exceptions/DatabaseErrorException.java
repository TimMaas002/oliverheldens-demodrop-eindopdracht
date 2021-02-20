package nl.novi.maas.oliverheldens.demodrop.exceptions;

public class DatabaseErrorException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public DatabaseErrorException() {
        super("Problem in database");
    }
}