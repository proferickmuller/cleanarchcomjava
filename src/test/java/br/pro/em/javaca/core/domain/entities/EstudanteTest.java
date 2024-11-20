package br.pro.em.javaca.core.domain.entities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EstudanteTest {

    @DisplayName("Cria estudante com sucesso")
    @Test
    void testEstudanteOk() {
        var estudante = Estudante.create("Erick", 44, "erick@em.pro.br");
        assertEquals(estudante.getNome(), "Erick");
        assertEquals(estudante.getIdade(), 44);
        assertNull(estudante.getIdentificacaoInterna());
        assertEquals(estudante.getEnderecoEmail(), "erick@em.pro.br");
    }

    @DisplayName("Cria estudante com identificacao, com sucesso")
    @Test
    void testEstudanteIdentificacaoOk() {
        var estudante = Estudante.create("abcd", "Erick", 44, "erick@em.pro.br");
        assertEquals(estudante.getNome(), "Erick");
        assertEquals(estudante.getIdade(), 44);
        assertEquals(estudante.getIdentificacaoInterna(), "abcd");
        assertEquals(estudante.getEnderecoEmail(), "erick@em.pro.br");
    }

    @DisplayName("Proibe Estudante sem nome")
    @Test
    void testEstudanteSemNome() {
        assertThrows(IllegalArgumentException.class, () -> {
            var estudante = Estudante.create(null, 44, "erick@em.pro.br");
        });
    }

    @DisplayName("Proibe alterar Estudante sem nome")
    @Test
    void testAlteraEstudanteSemNome() {
        var estudante = Estudante.create("Erick", 44, "erick@em.pro.br");
        assertThrows(IllegalArgumentException.class, () -> {
            estudante.setNome("");
        });

        assertThrows(IllegalArgumentException.class, () -> {
            estudante.setNome(null);
        });

    }
}