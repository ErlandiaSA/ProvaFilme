package br.com.tech4me.provafilme.view.model;

import java.util.List;

import br.com.tech4me.provafilme.compartilhado.Vendas;

public class FilmeModeloResponseDetalhes {
    private String id;
    private String nome;
    private String preco; 
    private Integer quantidade;
    private List<Vendas> vendas;

    public List<Vendas> getVendas() {
        return vendas;
    }
    public void setVendas(List<Vendas> vendas) {
        this.vendas = vendas;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPreco() {
        return preco;
    }
    public void setPreco(String preco) {
        this.preco = preco;
    }
    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    } 
    
    
}
