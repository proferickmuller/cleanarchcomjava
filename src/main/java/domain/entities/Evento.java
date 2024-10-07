package domain.entities;

import domain.exceptions.EventoInvalidoException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.ArrayList;
import java.util.Set;

public class Evento {
    @NotEmpty(message = "Nome não pode ser vazio")
    private String nome;
    @Positive(message = "Lotação deve ser positiva")
    private Integer lotacao;
    @NotNull(message = "Restrito não pode ser nulo")
    private boolean isRestrito;

    private String id = "";
    private final ArrayList<DataEvento> datas = new ArrayList<>();


    public ArrayList<DataEvento> getDatas() {
        return datas;
    }

    public void adicionarData(DataEvento data) {
        this.datas.add(data);
    }

    public String getNome() {
        return nome;
    }

    public boolean isRestrito() {
        return isRestrito;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public String getId() {
        return id;
    }

    public static Evento create(String nome, Integer lotacao, boolean restrito, String id) throws EventoInvalidoException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        var evento = new Evento();
        evento.nome = nome;
        evento.lotacao = lotacao;
        evento.isRestrito = restrito;

        if (!id.isEmpty()) {
            evento.id = id;
        }

        Set<ConstraintViolation<Evento>> violations = validator.validate(evento);
        if (!violations.isEmpty()) {
            throw new EventoInvalidoException(violations.iterator().next().getMessage());
        }

        return evento;
    }

    public static Evento create(String nome, Integer lotacao, boolean restrito) throws EventoInvalidoException {
        return create(nome, lotacao, restrito, "");
    }
}