package br.com.tech4me.vendas.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.vendas.Model.Vendas;
import br.com.tech4me.vendas.compartilhado.VendaDto;

import br.com.tech4me.vendas.repository.VendaRepositorio;

@Service
public class VendaServiceImpl implements VendaService {
    @Autowired
    private VendaRepositorio repo;

    @Override
    public VendaDto criarVenda(VendaDto Venda) {
        return salvarVenda(Venda);
    }

    @Override
    public List<VendaDto> obterTodos() {
        List<Vendas> animais = repo.findAll();

        return animais.stream()
            .map(Venda -> new ModelMapper().map(Venda, VendaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<VendaDto> obterPorId(String id) {
        Optional<Vendas> Venda = repo.findById(id);

       if(Venda.isPresent()) {
           return Optional.of(new ModelMapper().map(Venda.get(), VendaDto.class));
       }

       return Optional.empty();
    }

    @Override
    public List<VendaDto> obterPorFilme(String filmeNm) {
        List<Vendas> animais = repo.findByDono(filmeNm);

        return animais.stream()
            .map(Venda -> new ModelMapper().map(Venda, VendaDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public void removerVenda(String id) {
        repo.deleteById(id);
    }

    @Override
    public VendaDto atualizarVenda(String id, VendaDto Venda) {
        Venda.setId(id);
        return salvarVenda(Venda);
    }

    private VendaDto salvarVenda(VendaDto Venda) {
        ModelMapper mapper = new ModelMapper();
        Vendas VendaEntidade = mapper.map(Venda, Vendas.class);
        VendaEntidade = repo.save(VendaEntidade);

        return mapper.map(VendaEntidade, VendaDto.class);
    }
    
}