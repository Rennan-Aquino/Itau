package com.itau.banco.repository;

import com.itau.banco.domain.Endereco;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "endereco", url = "https://viacep.com.br/ws")
public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
    @RequestMapping(method = RequestMethod.PUT, value = "{cep}/json")
    Endereco getEnderecosByCep(@PathVariable String cep);

    Page<Endereco> findAll(Pageable pageable);
}
