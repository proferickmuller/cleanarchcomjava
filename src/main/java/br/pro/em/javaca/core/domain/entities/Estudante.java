package br.pro.em.javaca.core.domain.entities;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import org.apache.commons.validator.routines.EmailValidator;

@Getter
@EqualsAndHashCode
public class Estudante {
    private String identificacaoInterna;
    private String nome;
    private int idade;
    private String enderecoEmail;


    public static Estudante create(String nome, int idade, String enderecoEmail)
            throws IllegalArgumentException
    {
        if (nome == null || enderecoEmail == null) {
            throw new IllegalArgumentException("Null data");
        }

        validateNome(nome);
        validateIdade(idade);
        validateEnderecoEmail(enderecoEmail);

        Estudante estudante = new Estudante();
        estudante.setNome(nome);
        estudante.setIdade(idade);
        estudante.setEnderecoEmail(enderecoEmail);

        return estudante;
    }

    public static Estudante create(String identificaoInterna, String nome, int idade, String enderecoEmail)
            throws IllegalArgumentException
    {
        if (nome == null || enderecoEmail == null) {
            throw new IllegalArgumentException("Null data");
        }

        Estudante estudante = new Estudante();
        estudante.setIdentificacaoInterna(identificaoInterna);
        estudante.setNome(nome);
        estudante.setIdade(idade);
        estudante.setEnderecoEmail(enderecoEmail);

        return estudante;
    }

    private static void validateEnderecoEmail(String enderecoEmail) {
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(enderecoEmail)) {
            throw new IllegalArgumentException("Email inválido");
        }
    }

    private static void validateIdade(int idade) {
        // aqui temos uma regra de negócio referente à idade.
        // como não podemos ter Estudante como idade menor que 18,
        // validamos na entidade
        if (idade < 18) {
            throw new IllegalArgumentException("Idade deve ser maior que 18");
        }
    }

    private static void validateNome(String nome) {
        if(nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome Inválido");
        }
     }

     private static void validateIdentificacaoInterna(String identificacaoInterna) {
        if (identificacaoInterna == null || identificacaoInterna.trim().isEmpty()) {
            throw new IllegalArgumentException("Identificacao Interna Invalida");
        }
     }

    public void setIdentificacaoInterna(String identificacaoInterna) {
        validateIdentificacaoInterna(identificacaoInterna);
        this.identificacaoInterna = identificacaoInterna;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        validateNome(nome);
        this.nome = nome;
    }

    public void setIdade(int idade) throws IllegalArgumentException {
        validateIdade(idade);
        this.idade = idade;
    }

    public void setEnderecoEmail(String enderecoEmail) throws IllegalArgumentException {
        validateEnderecoEmail(enderecoEmail);
        this.enderecoEmail = enderecoEmail;
    }

}
