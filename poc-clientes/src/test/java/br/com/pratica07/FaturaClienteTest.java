package br.com.pratica07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FaturaClienteTest {

    @Test
    void deveCriarFaturaComDadosInformados() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);

        assertEquals(1, fatura.getId());
        assertEquals(cliente, fatura.getCliente());
        assertEquals(100.0, fatura.getValor());
    }

    @Test
    void deveCalcularValorComDesconto() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);

        assertEquals(90.0, fatura.getValorComDesconto(), 0.001);
    }

    @Test
    void deveCalcularValorComDescontoDeVintePorCento() {
        Cliente cliente = new Cliente(2, "Maria", 20);
        FaturaCliente fatura = new FaturaCliente(2, cliente, 200.0);

        assertEquals(160.0, fatura.getValorComDesconto(), 0.001);
    }

    @Test
    void deveManterValorQuandoDescontoForZero() {
        Cliente cliente = new Cliente(3, "Alex", 0);
        FaturaCliente fatura = new FaturaCliente(3, cliente, 150.0);

        assertEquals(150.0, fatura.getValorComDesconto(), 0.001);
    }
}