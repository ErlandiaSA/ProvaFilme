package br.com.tech4me.provafilme.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.provafilme.model.Filme;

@Repository
public interface FilmeRepository extends MongoRepository<Filme, String> {
    
}