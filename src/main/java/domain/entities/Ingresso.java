package domain.entities;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.util.Set;

public class Ingresso {
    @Future(message = "Data deve ser futura")
    DataEvento dataEvento;
    @NotNull(message = "Pessoa não pode ser nulo")
    Pessoa pessoa;

    public DataEvento getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(DataEvento dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

    public static Ingresso create(DataEvento dataEvento, Pessoa pessoa) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        var ingresso = new Ingresso();
        ingresso.setDataEvento(dataEvento);
        ingresso.setPessoa(pessoa);
        Set<ConstraintViolation<Ingresso>> violations = validator.validate(ingresso);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException(violations.iterator().next().getMessage());
        }
        return ingresso;
    }

}
