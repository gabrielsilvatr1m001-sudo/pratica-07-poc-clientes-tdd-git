package br.com.pratica07;

public class Cliente {

    private int id;
    private String nome;
    private int desconto;
    private String genero;

    public Cliente(int id, String nome, int desconto, String genero) {
        this.id = id;
        this.nome = nome;
        this.desconto = desconto;
        setGenero(genero);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDesconto() {
        return desconto;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero == null ||
            !(genero.equals("m") || genero.equals("f") || genero.equals("nd"))) {
            throw new IllegalArgumentException(
                "Gênero deve ser m, f ou nd"
            );
        }

        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", desconto=" + desconto +
                ", genero='" + genero + '\'' +
                '}';
    }
}