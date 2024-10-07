package domain.usecases;

import common.interfaces.DataSourcePessoa;
import domain.entities.Pessoa;
import domain.exceptions.PessoaInvalidaException;

public class CadastrarPessoa {

    private final DataSourcePessoa dataSourcePessoa;

    public CadastrarPessoa(DataSourcePessoa dataSourcePessoa) {
        this.dataSourcePessoa = dataSourcePessoa;
    }

    public Pessoa execute(String nome, String documento, Integer idade) {
        try {
            Pessoa pessoa = Pessoa.create(nome, documento, idade);
            return dataSourcePessoa.Criar(pessoa);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (PessoaInvalidaException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


}
