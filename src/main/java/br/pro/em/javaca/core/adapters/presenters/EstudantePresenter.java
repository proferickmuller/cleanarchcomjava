package br.pro.em.javaca.core.adapters.presenters;

import br.pro.em.javaca.core.domain.entities.Estudante;
import br.pro.em.javaca.core.dto.EstudanteDTO;

public class EstudantePresenter {

    public static EstudanteDTO ToDTO(Estudante estudante) {
        final String identificacao = estudante.getIdentificacaoInterna();
        final String identificacaoOfuscada = identificacao.charAt(1) + "..." + identificacao.charAt(identificacao.length() - 1);

        EstudanteDTO estudanteDTO = new EstudanteDTO(
                identificacaoOfuscada,
                estudante.getNome(),
                estudante.getIdade(),
                estudante.getEnderecoEmail()
        );
        return estudanteDTO;
    }

}
