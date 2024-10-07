package domain.exceptions;

public class EventoInvalidoException extends Exception {
    public EventoInvalidoException() {}

    public EventoInvalidoException(String message) {
        super(message);
    }
}

