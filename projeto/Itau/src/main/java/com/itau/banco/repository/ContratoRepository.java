package com.itau.banco.repository;

import com.itau.banco.domain.Contrato;
import com.itau.banco.domain.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContratoRepository extends JpaRepository <Contrato, Integer> {
    Page<Contrato> findAll(Pageable pageable);
}
