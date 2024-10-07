package domain.exceptions;

public class PessoaInvalidaException extends Exception {
    public PessoaInvalidaException() {}

    public PessoaInvalidaException(String message) {
        super(message);
    }
}

