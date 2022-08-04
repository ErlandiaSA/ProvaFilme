package br.com.tech4me.provafilme.compartilhado;

import java.time.LocalDate;

public class Vendas {
    private String id;
    private int codigo;
    private int quantidade;
    private LocalDate data;
    private String filmeNm;
    private double valorTotal;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public int getCodigo() {
        return codigo;
    }
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }
    public String getFilmeNm() {
        return filmeNm;
    }
    public void setFilmeNm(String filmeNm) {
        this.filmeNm = filmeNm;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    } 
}
