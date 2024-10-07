package domain.entities;

import domain.exceptions.DataEventoInvalidaException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.Future;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.ArrayList;


public class DataEvento {
    @Future(message = "Data deve ser futura")
    private LocalDateTime data;

    private final ArrayList<Ingresso> ingressos = new ArrayList<>();

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public static DataEvento create(LocalDateTime data) throws DataEventoInvalidaException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        DataEvento dataEvento = new DataEvento();
        dataEvento.setData(data);

        Set<ConstraintViolation<DataEvento>> violations = validator.validate(dataEvento);
        if (!violations.isEmpty()) {
            throw new DataEventoInvalidaException(violations.iterator().next().getMessage());
        }

        return dataEvento;
    }

}
