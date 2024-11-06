package br.pro.em.javaca.core.adapters.controllers;

import br.pro.em.javaca.core.adapters.gateways.EstudanteGateway;
import br.pro.em.javaca.core.adapters.presenters.EstudantePresenter;
import br.pro.em.javaca.core.domain.usecases.CadastrarEstudanteUseCase;
import br.pro.em.javaca.core.dto.EstudanteDTO;
import br.pro.em.javaca.core.dto.NovoEstudanteDTO;
import br.pro.em.javaca.core.exceptions.EstudanteJaExistenteException;
import br.pro.em.javaca.core.interfaces.IDataStorageSource;

public class EstudanteController {

    private final IDataStorageSource dataStorageSource;

    private EstudanteController (IDataStorageSource dataStorageSource) {
        this.dataStorageSource = dataStorageSource;
    }

    public static EstudanteController create (IDataStorageSource dataStorageSource) {
        return new EstudanteController(dataStorageSource);
    }

    public EstudanteDTO Cadastrar(NovoEstudanteDTO novoEstudanteDTO) {
        var estudanteGateway = EstudanteGateway.create(this.dataStorageSource);
        var useCase = CadastrarEstudanteUseCase.create(estudanteGateway);
        try {
            var estudante = useCase.run(novoEstudanteDTO);
            var estudanteDto = EstudantePresenter.ToDTO(estudante);
            return estudanteDto;
        } catch (EstudanteJaExistenteException e) {
            return null;  // deve retornar algo melhor
        }
    }

}
