package br.com.tech4me.vendas.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import br.com.tech4me.vendas.Model.Vendas;


@Repository
public interface VendaRepositorio extends MongoRepository<Vendas, String> {

	List<Vendas> findByDono(String filmeNm);
    
}
