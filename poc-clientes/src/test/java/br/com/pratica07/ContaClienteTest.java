package br.com.pratica07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaClienteTest {

    @Test
    void deveCriarContaComSaldoInicialZero() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);
        ContaCliente conta = new ContaCliente(1, cliente);

        assertEquals(1, conta.getId());
        assertEquals(cliente, conta.getCliente());
        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveCriarContaComSaldoInformado() {
        Cliente cliente = new Cliente(2, "Maria", 10);
        ContaCliente conta = new ContaCliente(2, cliente, 500.0);

        assertEquals(2, conta.getId());
        assertEquals(cliente, conta.getCliente());
        assertEquals(500.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveCriarContaInformandoApenasId() {
        ContaCliente conta = new ContaCliente(3);

        assertEquals(3, conta.getId());
        assertNull(conta.getCliente());
        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveAlterarClienteDaConta() {
        ContaCliente conta = new ContaCliente(1);
        Cliente cliente = new Cliente(1, "Gabriel", 10);

        conta.setCliente(cliente);

        assertEquals(cliente, conta.getCliente());
    }

    @Test
    void deveAlterarSaldoDaConta() {
        ContaCliente conta = new ContaCliente(1);

        conta.setSaldo(300.0);

        assertEquals(300.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveAdicionarDepositoAoSaldo() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);
        ContaCliente conta = new ContaCliente(1, cliente);

        double novoSaldo = conta.addDeposito(100.0);

        assertEquals(100.0, novoSaldo, 0.001);
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void devePermitirDepositosSucessivos() {
        Cliente cliente = new Cliente(3, "Alex", 0);
        ContaCliente conta = new ContaCliente(3, cliente);

        conta.addDeposito(100.0);
        double novoSaldo = conta.addDeposito(50.0);

        assertEquals(150.0, novoSaldo, 0.001);
        assertEquals(150.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSubtrairValorDoSaldo() {
        Cliente cliente = new Cliente(2, "Maria", 10);
        ContaCliente conta = new ContaCliente(2, cliente, 200.0);

        double novoSaldo = conta.subSaldo(50.0);

        assertEquals(150.0, novoSaldo, 0.001);
        assertEquals(150.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveManterSaldoQuandoNaoHouverSaldoSuficiente() {
        Cliente cliente = new Cliente(4, "Joao", 0);
        ContaCliente conta = new ContaCliente(4, cliente, 100.0);

        double novoSaldo = conta.subSaldo(150.0);

        assertEquals(100.0, novoSaldo, 0.001);
        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveRetornarRepresentacaoTextualDaConta() {
        Cliente cliente = new Cliente(1, "Gabriel", 10);
        ContaCliente conta = new ContaCliente(1, cliente, 100.0);

        assertEquals("Gabriel(1) saldo=R$100.00", conta.toString());
    }
}