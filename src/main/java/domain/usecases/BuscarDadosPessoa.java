package domain.usecases;

import common.interfaces.DataSourcePessoa;
import domain.entities.Pessoa;

public class BuscarDadosPessoa {

    private final DataSourcePessoa dataSourcePessoa;

    public BuscarDadosPessoa(DataSourcePessoa dataSourcePessoa) {
        this.dataSourcePessoa = dataSourcePessoa;
    }

    public Pessoa execute(String documento) {
        if (documento.isEmpty()) {
            return null;
        }
        return dataSourcePessoa.BuscarPorDocumento(documento);
    }
}
