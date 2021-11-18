package com.itau.banco.repository;

import com.itau.banco.domain.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PessoaRepository extends JpaRepository <Pessoa, Integer> {
   Pessoa findByCpf(String cpf); //consultar pessoa por cpf

   Page<Pessoa> findAll(Pageable pageable);
}
