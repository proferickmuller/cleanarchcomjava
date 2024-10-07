package domain.entities;

import domain.exceptions.PessoaInvalidaException;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.Set;

public class Pessoa {
    @NotEmpty(message = "Nome não pode ser nulo")
    private String nome;
    @NotNull(message = "Documento não pode ser nulo")
    private String documento;
    @Positive(message = "Idade deve ser positiva")
    private Integer idade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public static Pessoa create(String nome, String documento, Integer idade) throws PessoaInvalidaException {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        var pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setDocumento(documento);
        pessoa.setIdade(idade);
        Set<ConstraintViolation<Pessoa>> violations = validator.validate(pessoa);
        if (!violations.isEmpty()) {
            throw new PessoaInvalidaException(violations.iterator().next().getMessage());
        }
        return pessoa;
    }
}
