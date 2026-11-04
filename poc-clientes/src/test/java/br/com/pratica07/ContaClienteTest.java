package br.com.pratica07;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaClienteTest {

    @Test
    void deveCriarContaComSaldoInicialZero() {
        Cliente cliente = new Cliente(1, "Gabriel", 10, "m");
        ContaCliente conta = new ContaCliente(1, cliente);

        assertEquals(1, conta.getId());
        assertEquals(cliente, conta.getCliente());
        assertEquals(0.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveAdicionarDepositoAoSaldo() {
        Cliente cliente = new Cliente(1, "Gabriel", 10, "m");
        ContaCliente conta = new ContaCliente(1, cliente);

        conta.addDeposito(100.0);

        assertEquals(100.0, conta.getSaldo(), 0.001);
    }

    @Test
    void deveSubtrairValorDoSaldo() {
        Cliente cliente = new Cliente(2, "Maria", 10, "f");
        ContaCliente conta = new ContaCliente(2, cliente);

        conta.addDeposito(200.0);
        conta.subSaldo(50.0);

        assertEquals(150.0, conta.getSaldo(), 0.001);
    }

    @Test
    void devePermitirDepositosSucessivos() {
        Cliente cliente = new Cliente(3, "Alex", 0, "nd");
        ContaCliente conta = new ContaCliente(3, cliente);

        conta.addDeposito(100.0);
        conta.addDeposito(50.0);

        assertEquals(150.0, conta.getSaldo(), 0.001);
    }
}