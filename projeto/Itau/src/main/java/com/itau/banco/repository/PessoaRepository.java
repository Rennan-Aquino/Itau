package com.itau.banco.repository;

import com.itau.banco.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository <Pessoa, Integer> {
}
