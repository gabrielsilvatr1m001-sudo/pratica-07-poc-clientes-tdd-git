package br.com.pratica07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    @Test
    void deveCriarClienteComDadosInformados() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);

        assertEquals(1, cliente.getId());
        assertEquals("Gabriel", cliente.getNome());
        assertEquals(10, cliente.getDesconto());
        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void deveAlterarDescontoDoCliente() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);

        cliente.setDesconto(20);

        assertEquals(20, cliente.getDesconto());
    }

    @Test
    void deveRetornarGeneroNaoDeclaradoPorPadrao() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);

        assertEquals("nd", cliente.getGenero());
    }

    @Test
    void deveRetornarRepresentacaoTextualDoCliente() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);

        assertEquals("Gabriel(1)(10%)", cliente.toString());
    }
}