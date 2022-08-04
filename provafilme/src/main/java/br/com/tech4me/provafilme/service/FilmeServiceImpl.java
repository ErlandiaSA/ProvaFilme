package br.com.tech4me.provafilme.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4me.provafilme.clienteHTTP.VendasFeignClient;
import br.com.tech4me.provafilme.compartilhado.FilmesDto;
import br.com.tech4me.provafilme.model.Filme;
import br.com.tech4me.provafilme.repository.FilmeRepository;

@Service
public class FilmeServiceImpl implements FilmeService {
    @Autowired
    private FilmeRepository repo;

    @Autowired
    private VendasFeignClient VendasMsClient;

    @Override
    public FilmesDto criarFilme(FilmesDto Filme) {
        return salvarFilme(Filme);
    }

    @Override
    public List<FilmesDto> obterTodos() {
        List<Filme> Filmes = repo.findAll();

        return Filmes.stream()
            .map(Filme -> new ModelMapper().map(Filme, FilmesDto.class))
            .collect(Collectors.toList());
    }

    @Override
    public Optional<FilmesDto> obterPorId(String id) {
        Optional<Filme> Filme = repo.findById(id);
 
         
        if(Filme.isPresent()) {
            FilmesDto dto = new ModelMapper().map(Filme.get(), FilmesDto.class);
            dto.setVendas(VendasMsClient.obterVendas(id));
            return Optional.of(dto);
        }
 
        return Optional.empty();
     }

    @Override
    public void removerFilme(String id) {
        repo.deleteById(id);
    }

    @Override
    public FilmesDto atualizarFilme(String id, FilmesDto Filme) {
        Filme.setId(id);
        return salvarFilme(Filme);
    }

    private FilmesDto salvarFilme(FilmesDto Filme) {
        ModelMapper mapper = new ModelMapper();
        Filme FilmeEntidade = mapper.map(Filme, Filme.class);
        FilmeEntidade = repo.save(FilmeEntidade);

        return mapper.map(FilmeEntidade, FilmesDto.class);
    }
}

