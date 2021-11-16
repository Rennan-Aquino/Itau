package com.itau.banco.repository;

import com.itau.banco.domain.Pessoa;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@DisplayName("Testes para o repositório de Pessoa")
class PessoaRepositoryTest {
    @Autowired
    private PessoaRepository pessoaRepository;
    @Test
    void test() {

    }



}