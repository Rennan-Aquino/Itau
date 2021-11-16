package com.itau.banco.controller;

import com.itau.banco.domain.Pessoa;
import com.itau.banco.repository.PessoaRepository;
import com.itau.banco.util.PessoaCreator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.PageImpl;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
class PessoaControllerTest {
    @InjectMocks   // utilizado quando você quer testar a classe em si
    private PessoaController pessoaController;

    @Mock     // utilazado para testar todas as classes dentro do cotroller, nesse caso PessoaController
    private PessoaRepository pessoaRepositoryMock;

    @BeforeEach
    void setup() {
      //  PageImpl<Pessoa> pessoaPage = new PageImpl<>(List.of(PessoaCreator.));
    }
    @Test
    void test() {


    }

}