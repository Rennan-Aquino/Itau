package com.itau.banco.repository;

import com.itau.banco.domain.Contrato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContratoRepository extends JpaRepository <Contrato, Integer> {
}
