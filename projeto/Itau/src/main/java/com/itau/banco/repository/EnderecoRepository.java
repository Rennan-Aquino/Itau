package com.itau.banco.repository;

import com.itau.banco.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository <Endereco, Integer> {
}
