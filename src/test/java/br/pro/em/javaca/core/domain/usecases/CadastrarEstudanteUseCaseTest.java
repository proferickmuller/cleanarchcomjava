package br.pro.em.javaca.core.domain.usecases;

import br.pro.em.javaca.core.domain.entities.Estudante;
import br.pro.em.javaca.core.dto.NovoEstudanteDTO;
import br.pro.em.javaca.core.exceptions.EstudanteJaExistenteException;
import br.pro.em.javaca.core.interfaces.IEstudanteGateway;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class CadastrarEstudanteUseCaseTest {
    @Test
    @DisplayName("Cadastra com sucesso")
    void testeRegistrandoOk() {
        /* arrange */
        String nomeTestar = "Nome Teste";
        IEstudanteGateway IEstudanteGateway = mock(IEstudanteGateway.class);
        when(IEstudanteGateway.buscarPorNome(anyString())).thenReturn(
                null
        );
        when(IEstudanteGateway.incluir(any())).thenReturn(
                Estudante.create("abc", nomeTestar, 40, "teste@teste.com")
        );

        /* act */
        final Estudante estudante = CadastrarEstudanteUseCase.create(IEstudanteGateway).run(
                new NovoEstudanteDTO(nomeTestar, 40, "teste@teste.com"));

        /* assert */
        assertNotNull(estudante);
        assertEquals(estudante.getNome(), nomeTestar);
        assertEquals(estudante.getIdentificacaoInterna(), "abc");
    }

    @Test
    @DisplayName("Cadastra sem sucesso")
    void testeErroNoRegistro() {
        String nomeTestar = "Nome Teste";

        IEstudanteGateway IEstudanteGateway = mock(IEstudanteGateway.class);
        when(IEstudanteGateway.buscarPorNome(anyString())).thenReturn(
                Estudante.create("abc", nomeTestar, 40, "teste@teste.com")
        );
        when(IEstudanteGateway.incluir(any())).thenReturn(
                Estudante.create("abc", nomeTestar, 40, "teste@teste.com")
        );

        assertThrows(EstudanteJaExistenteException.class, () -> {
            final Estudante estudante = CadastrarEstudanteUseCase.create(IEstudanteGateway).run(
                    new NovoEstudanteDTO(nomeTestar, 40, "teste@teste.com"));
        });
    }


}