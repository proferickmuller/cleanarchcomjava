package domain.usecases;

import common.interfaces.DataSourceCliente;
import common.interfaces.exceptions.DataSourceClienteException;
import domain.entities.Cliente;
import domain.entities.Pessoa;
import domain.exceptions.ClienteInvalidoException;

public class CadastrarCliente {


    private final DataSourceCliente dataSourceCliente;

    public CadastrarCliente(DataSourceCliente dataSourceCliente) {
        this.dataSourceCliente = dataSourceCliente;
    }

    public Cliente executar(Pessoa pessoa, String enderecoEmail) {
        try {
            Cliente cliente = Cliente.create(pessoa, enderecoEmail);
            return dataSourceCliente.Criar(cliente);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } catch (ClienteInvalidoException | DataSourceClienteException e) {
            throw new RuntimeException(e);
        }

        return null;
    }
}
