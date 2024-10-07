package domain.usecases;

import common.interfaces.DataSourceEvento;
import domain.entities.Evento;
import domain.exceptions.EventoInvalidoException;

public class CadastrarEvento  {

    private final DataSourceEvento dataSourceEvento;

    public CadastrarEvento(DataSourceEvento dataSourceEvento) {
        this.dataSourceEvento = dataSourceEvento;
    }

    public Evento execute(String nome, Integer lotacao, boolean restrito) {
        try {
            Evento evento = Evento.create(nome, lotacao, restrito);
            return dataSourceEvento.Criar(evento);
        } catch (EventoInvalidoException e) {
            throw new RuntimeException(e);
        }
    }
}
