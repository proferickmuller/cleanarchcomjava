package common.interfaces;

import common.interfaces.exceptions.DataSourceClienteException;
import domain.entities.Cliente;

public interface DataSourceCliente {
    Cliente Criar(Cliente cliente) throws DataSourceClienteException;
}
