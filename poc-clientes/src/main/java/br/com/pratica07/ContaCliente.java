package br.com.pratica07;

public class ContaCliente {

    private int id;
    private Cliente cliente;
    private double saldo = 0.0;

    public ContaCliente(int id, Cliente cliente) {
        this.id = id;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void addDeposito(double valor) {
        saldo += valor;
    }

    public void subSaldo(double valor) {
        saldo -= valor;
    }

    @Override
    public String toString() {
        return "ContaCliente{" +
                "id=" + id +
                ", cliente=" + cliente +
                ", saldo=" + saldo +
                '}';
    }
}