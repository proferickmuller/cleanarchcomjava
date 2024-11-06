package br.pro.em.javaca.core.interfaces;

import br.pro.em.javaca.core.domain.entities.Estudante;

public interface IEstudanteGateway {
    Estudante buscarPorIdentificacao(String identificacao);
    Estudante incluir(Estudante estudante);
    Estudante buscarPorNome(String nome);
}
