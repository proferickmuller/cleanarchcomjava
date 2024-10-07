package domain.exceptions;

public class ClienteInvalidoException extends Exception {
    public ClienteInvalidoException() {}

    public ClienteInvalidoException(String message) {
        super(message);
    }
}

