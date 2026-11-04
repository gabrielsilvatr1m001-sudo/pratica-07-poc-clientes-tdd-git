package br.com.pratica07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveCriarClienteComDadosInformados() {
        Cliente cliente = new Cliente(1, "Gabriel", 10, "m");

        assertEquals(1, cliente.getId());
        assertEquals("Gabriel", cliente.getNome());
        assertEquals(10, cliente.getDesconto());
        assertEquals("m", cliente.getGenero());
    }

    @Test
    void deveAceitarGeneroMasculino() {
        Cliente cliente = new Cliente(1, "Gabriel", 10, "m");
        assertEquals("m", cliente.getGenero());
    }

    @Test
    void deveAceitarGeneroFeminino() {
        Cliente cliente = new Cliente(2, "Maria", 10, "f");
        assertEquals("f", cliente.getGenero());
    }

    @Test
    void deveAceitarGeneroNaoDeclarado() {
        Cliente cliente = new Cliente(3, "Alex", 10, "nd");
        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void naoDeveAceitarGeneroInvalido() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente(4, "João", 10, "x");
        });
    }

    @Test
    void naoDeveAceitarGeneroNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Cliente(5, "João", 10, null);
        });
    }
}