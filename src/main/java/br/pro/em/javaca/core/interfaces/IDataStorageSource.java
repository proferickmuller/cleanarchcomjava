package br.pro.em.javaca.core.interfaces;

import br.pro.em.javaca.core.dto.EstudanteDTO;
import br.pro.em.javaca.core.dto.NovoEstudanteDTO;

public interface IDataStorageSource {
    EstudanteDTO obterEstudantePorIdentificacao(String identificacao);

    EstudanteDTO incluirEstudante(NovoEstudanteDTO novoEstudante);

    EstudanteDTO obterEstudantePorNome(String nome);
}
