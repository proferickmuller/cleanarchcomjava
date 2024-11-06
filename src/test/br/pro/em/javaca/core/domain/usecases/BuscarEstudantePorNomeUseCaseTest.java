package br.pro.em.javaca.core.domain.usecases;

import br.pro.em.javaca.core.domain.entities.Estudante;
import br.pro.em.javaca.core.exceptions.EstudanteNaoEncontradoException;
import br.pro.em.javaca.core.interfaces.IEstudanteGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BuscarEstudantePorNomeUseCaseTest {

    @Test
    @DisplayName("Busca com sucesso")
    void testeEncontrando() {
        String nomeTestar = "Nome Teste";

        IEstudanteGateway IEstudanteGateway = mock(IEstudanteGateway.class);
        when(IEstudanteGateway.buscarPorNome(anyString())).thenReturn(
                Estudante.create(nomeTestar, 40, "teste@teste.com")
        );
        final Estudante estudante = BuscarEstudantePorNomeUseCase.create(IEstudanteGateway).run(nomeTestar);
        assertNotNull(estudante);
        assertEquals(estudante.getNome(), nomeTestar);
    }

    @Test
    @DisplayName("Busca inexistente")
    void testeNaoEncontrando() {
        String nomeTestar = "Nome Teste";

        IEstudanteGateway IEstudanteGateway = mock(IEstudanteGateway.class);
        when(IEstudanteGateway.buscarPorNome(anyString())).thenReturn(null);

        assertThrows(EstudanteNaoEncontradoException.class, () -> {
            final Estudante estudante = BuscarEstudantePorNomeUseCase.create(IEstudanteGateway).run(nomeTestar);
        });

    }
}