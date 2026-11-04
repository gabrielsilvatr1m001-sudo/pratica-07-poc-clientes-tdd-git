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
}