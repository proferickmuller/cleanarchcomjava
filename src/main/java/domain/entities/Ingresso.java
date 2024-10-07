package domain.entities;

import domain.exceptions.IngressoInvalidoException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class Ingresso {
    @NotNull(message = "Evento não pode ser nulo")
    Evento evento;

    @Future(message = "Data deve ser futura")
    DataEvento dataEvento;

    @NotNull(message = "Pessoa não pode ser nulo")
    Pessoa pessoa;

    public DataEvento getDataEvento() {
        return dataEvento;
    }


    public Pessoa getPessoa() {
        return pessoa;
    }


    public Evento getEvento() {
        return evento;
    }

    public static Ingresso create(Evento evento, DataEvento dataEvento, Pessoa pessoa) throws IngressoInvalidoException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        var ingresso = new Ingresso();
        ingresso.dataEvento = dataEvento;
        ingresso.pessoa = pessoa;
        ingresso.evento = evento;

        Set<ConstraintViolation<Ingresso>> violations = validator.validate(ingresso);
        if (!violations.isEmpty()) {
            throw new IngressoInvalidoException(violations.iterator().next().getMessage());
        }
        return ingresso;
    }

}