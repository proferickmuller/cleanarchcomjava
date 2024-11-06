package br.pro.em.javaca.core.domain.usecases;

import br.pro.em.javaca.core.domain.entities.Estudante;
import br.pro.em.javaca.core.exceptions.EstudanteNaoEncontradoException;
import br.pro.em.javaca.core.interfaces.IEstudanteGateway;

public class BuscarEstudantePorNomeUseCase {

    private final IEstudanteGateway gateway;

    private BuscarEstudantePorNomeUseCase(IEstudanteGateway gateway) {
        this.gateway = gateway;
    }

    public static BuscarEstudantePorNomeUseCase create(IEstudanteGateway gateway) {
        return new BuscarEstudantePorNomeUseCase(gateway);
    }

    public Estudante run(String nome) throws EstudanteNaoEncontradoException {
        Estudante estudante = gateway.buscarPorNome(nome);
        if (estudante == null) {
            throw new EstudanteNaoEncontradoException(nome);
        }
        return estudante;
    }
}
