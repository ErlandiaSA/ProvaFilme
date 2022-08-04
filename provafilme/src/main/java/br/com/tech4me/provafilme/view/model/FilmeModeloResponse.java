package br.com.tech4me.provafilme.view.model;

public class FilmeModeloResponse {
    private String nome;
    private double preco; 
    private Integer quantidade;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public String getDadosCompleto() {
        return String.format("Filme: %s Preço: %d Qtd Estoque: %d", nome, preco, quantidade);
    }

}
