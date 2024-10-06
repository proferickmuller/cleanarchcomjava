package domain.entities;

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

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isRestrito() {
        return isRestrito;
    }

    public void setRestrito(boolean restrito) {
        isRestrito = restrito;
    }

    public Integer getLotacao() {
        return lotacao;
    }

    public void setLotacao(Integer lotacao) {
        this.lotacao = lotacao;
    }

    public static Evento create(String nome, Integer lotacao, boolean restrito) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        var evento = new Evento();
        evento.setNome(nome);
        evento.setLotacao(lotacao);
        evento.setRestrito(restrito);

        Set<ConstraintViolation<Evento>> violations = validator.validate(evento);
        if (!violations.isEmpty()) {
            throw new IllegalArgumentException(violations.iterator().next().getMessage());
        }

        return evento;
    }
}