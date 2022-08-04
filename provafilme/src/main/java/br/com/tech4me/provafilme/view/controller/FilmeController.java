package br.com.tech4me.provafilme.view.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4me.provafilme.compartilhado.FilmesDto;
import br.com.tech4me.provafilme.model.Filme;
import br.com.tech4me.provafilme.service.FilmeService;
import br.com.tech4me.provafilme.view.model.FilmeModeloRequest;
import br.com.tech4me.provafilme.view.model.FilmeModeloResponse;
import br.com.tech4me.provafilme.view.model.FilmeModeloResponseDetalhes;


@RestController
@RequestMapping("/api/filmes")
public class FilmeController {
    @Autowired
    private FilmeService service;

    @GetMapping(value="/status")
    public String statusServico(@Value("${local.server.port}") String porta) {
        return String.format("Serviço ativo e executando na porta %s", porta);
    }
    

    @PostMapping
    public ResponseEntity<FilmeModeloResponse> criarFilme(@RequestBody @Valid FilmeModeloRequest Filme) {
        ModelMapper mapper = new ModelMapper();
        FilmesDto dto = mapper.map(Filme, FilmesDto.class);
        dto = service.criarFilme(dto);
        return new ResponseEntity<>(mapper.map(dto, FilmeModeloResponse.class), HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<FilmeModeloResponse>> obterTodos() {
        List<FilmesDto> dtos = service.obterTodos();

        if(dtos.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ModelMapper mapper = new ModelMapper();
        List<FilmeModeloResponse> resp = dtos.stream()
                    .map(dto -> mapper.map(dto, FilmeModeloResponse.class))
                    .collect(Collectors.toList());

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }
    
    @GetMapping(value="/{id}")
    public ResponseEntity<FilmeModeloResponseDetalhes> obterPorId(@PathVariable String id) {
        Optional<FilmesDto> Filme = service.obterPorId(id);

        if(Filme.isPresent()) {
            return new ResponseEntity<>(
                new ModelMapper().map(Filme.get(), FilmeModeloResponseDetalhes.class), 
                HttpStatus.OK
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<FilmeModeloResponse> atualizarFilme(@PathVariable String id,
        @Valid @RequestBody Filme Filme) {
        ModelMapper mapper = new ModelMapper();
        FilmesDto dto = mapper.map(Filme, FilmesDto.class);
        dto = service.atualizarFilme(id, dto);

        return new ResponseEntity<>(mapper.map(dto, FilmeModeloResponse.class), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<Void> removerFilme(@PathVariable String id) {
        service.removerFilme(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    } 
}
