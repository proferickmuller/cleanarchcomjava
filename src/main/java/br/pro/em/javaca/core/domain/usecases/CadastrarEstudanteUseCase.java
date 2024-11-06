package br.pro.em.javaca.core.domain.usecases;

import br.pro.em.javaca.core.dto.NovoEstudanteDTO;
import br.pro.em.javaca.core.domain.entities.Estudante;
import br.pro.em.javaca.core.exceptions.EstudanteJaExistenteException;
import br.pro.em.javaca.core.interfaces.IEstudanteGateway;

public class CadastrarEstudanteUseCase {
    private final IEstudanteGateway gateway;

    private CadastrarEstudanteUseCase(IEstudanteGateway gateway) {
        this.gateway = gateway;
    }

    public static CadastrarEstudanteUseCase create(IEstudanteGateway gateway) {
        return new CadastrarEstudanteUseCase(gateway);
    }

    public Estudante run(NovoEstudanteDTO novoEstudanteDTO) throws EstudanteJaExistenteException {
        final Estudante estudanteExistente = gateway.buscarPorNome(novoEstudanteDTO.nome());

        if (estudanteExistente != null) {
            throw new EstudanteJaExistenteException(novoEstudanteDTO.nome());
        }

        final Estudante novoEstudante = Estudante.create(
                novoEstudanteDTO.nome(),
                novoEstudanteDTO.idade(),
                novoEstudanteDTO.enderecoEmail()
        );

        Estudante estudante = gateway.incluir(novoEstudante);
        return estudante;
    }
}
