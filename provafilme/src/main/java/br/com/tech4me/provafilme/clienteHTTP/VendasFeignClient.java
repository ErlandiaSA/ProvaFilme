package br.com.tech4me.provafilme.clienteHTTP;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4me.provafilme.compartilhado.Vendas;

@FeignClient(name= "vendas-ms", fallback = VendasFeignClientFallback.class)
public interface VendasFeignClient {
    @GetMapping(path = "/api/vendas/{filmeNm}/lista")
    List<Vendas> obterVendas(@PathVariable String filmeNm);   
}

@Component
class VendasFeignClientFallback implements VendasFeignClient {

    @Override
    public List<Vendas> obterVendas(String filmeNm) {
        return new ArrayList<>();
    }
}
