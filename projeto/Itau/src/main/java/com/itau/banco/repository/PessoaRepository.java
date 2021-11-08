package com.itau.banco.repository;

import com.itau.banco.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

//import java.time.LocalDate;
//import java.util.List;

public interface PessoaRepository extends JpaRepository <Pessoa, Integer> {
    //List<Pessoa> consultarPorParametros(String cpf, double renda, LocalDate data);
}
