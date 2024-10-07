package common.interfaces;

import domain.entities.Pessoa;

public interface DataSourcePessoa {
    Pessoa Criar(Pessoa pessoa);

    Pessoa BuscarPorDocumento(String documento);
}
