package br.pro.em.javaca.core.adapters.gateways;

import br.pro.em.javaca.core.domain.entities.Estudante;
import br.pro.em.javaca.core.dto.EstudanteDTO;
import br.pro.em.javaca.core.dto.NovoEstudanteDTO;
import br.pro.em.javaca.core.exceptions.EstudanteNaoEncontradoException;
import br.pro.em.javaca.core.interfaces.IDataStorageSource;
import br.pro.em.javaca.core.interfaces.IEstudanteGateway;

public class EstudanteGateway implements IEstudanteGateway {

    private final IDataStorageSource dataStorageSource;

    private EstudanteGateway(IDataStorageSource dataStorageSource) {
        this.dataStorageSource = dataStorageSource;
    }

    public static EstudanteGateway create(IDataStorageSource dataStorageSource) {
        return new EstudanteGateway(dataStorageSource);
    }

    @Override
    public Estudante buscarPorIdentificacao(String identificacao) {
        EstudanteDTO estudanteDTO = this.dataStorageSource.obterEstudantePorIdentificacao(identificacao);
        if (estudanteDTO == null) {
            throw new EstudanteNaoEncontradoException(
                    "Estudante com identificação " + identificacao + " não encontrado");
        }
        return Estudante.create(estudanteDTO.identificacaoInterna(), estudanteDTO.nome(), estudanteDTO.idade(),
                estudanteDTO.enderecoEmail());
    }

    @Override
    public Estudante incluir(Estudante estudante) {
        final NovoEstudanteDTO novoEstudante = new NovoEstudanteDTO(estudante.getNome(), estudante.getIdade(),
                estudante.getEnderecoEmail());
        final EstudanteDTO estudanteCriado = this.dataStorageSource.incluirEstudante(novoEstudante);
        return Estudante.create(estudanteCriado.identificacaoInterna(), estudanteCriado.nome(),
                estudanteCriado.idade(), estudanteCriado.enderecoEmail());
    }

    @Override
    public Estudante buscarPorNome(String nome) {
        EstudanteDTO estudanteDTO = this.dataStorageSource.obterEstudantePorNome(nome);
        if (estudanteDTO == null) {
            throw new EstudanteNaoEncontradoException("Estudante com nome " + nome + " não encontrado");
        }
        return Estudante.create(estudanteDTO.identificacaoInterna(), estudanteDTO.nome(), estudanteDTO.idade(),
                estudanteDTO.enderecoEmail());
    }
}