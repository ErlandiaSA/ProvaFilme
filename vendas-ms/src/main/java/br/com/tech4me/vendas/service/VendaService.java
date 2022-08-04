package br.com.tech4me.vendas.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.vendas.compartilhado.VendaDto;

public interface VendaService {
    VendaDto criarVenda(VendaDto Venda);
    List<VendaDto> obterTodos();
    Optional<VendaDto> obterPorId(String id);
    List<VendaDto> obterPorFilme(String filmeNm);
    void removerVenda(String id);
    VendaDto atualizarVenda(String id, VendaDto Venda);
}

