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
    void deveCriarFaturaInformandoApenasId() {
        FaturaCliente fatura = new FaturaCliente(2);

        assertEquals(2, fatura.getId());
        assertNull(fatura.getCliente());
        assertEquals(0.0, fatura.getValor(), 0.001);
    }

    @Test
    void deveAlterarClienteDaFatura() {
        FaturaCliente fatura = new FaturaCliente(1);
        Cliente cliente = new Cliente(1, "Gabriel", 10);

        fatura.setCliente(cliente);

        assertEquals(cliente, fatura.getCliente());
    }

    @Test
    void deveAlterarValorDaFatura() {
        FaturaCliente fatura = new FaturaCliente(1);

        fatura.setValor(250.0);

        assertEquals(250.0, fatura.getValor(), 0.001);
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

    @Test
    void deveRetornarRepresentacaoTextualDaFatura() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);
        FaturaCliente fatura = new FaturaCliente(1, cliente, 100.0);

        assertEquals(
                "Fatura [id=1, cliente=Gabriel(1)(10%), valor=100.0 ]",
                fatura.toString()
        );
    }
}