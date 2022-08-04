package br.com.tech4me.provafilme.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4me.provafilme.compartilhado.FilmesDto;

public interface FilmeService {
    FilmesDto criarFilme(FilmesDto Filme);
    List<FilmesDto> obterTodos();
    Optional<FilmesDto> obterPorId(String id);
    void removerFilme(String id);
    FilmesDto atualizarFilme(String id, FilmesDto filme);
}

