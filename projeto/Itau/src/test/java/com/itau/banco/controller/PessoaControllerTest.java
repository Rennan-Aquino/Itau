package com.itau.banco.controller;

import com.itau.banco.domain.Pessoa;
import com.itau.banco.repository.PessoaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {PessoaController.class, PessoaRepository.class})
class PessoaControllerTest {

    @Autowired
    PessoaController controller;

    @MockBean
    PessoaRepository repository;


    @Test
    void encontraPorId() {
        Pessoa pessoa = new Pessoa();
        pessoa.setId_usuario(1);

        when(repository.findById(1)).thenReturn(java.util.Optional.of(pessoa));
        ResponseEntity resposta = controller.findById(1);

        assertEquals(1,((Pessoa) resposta.getBody()).getId_usuario());
        assertEquals(200, resposta.getStatusCode().value());
    }

    @Test
    void consultaLimitePorCpfRendaAniversario() {
        when(repository.findAll()).thenReturn(new ArrayList<>());
        ResponseEntity resposta = controller.consultarLimite("99999999999", 10000.00, LocalDate.ofEpochDay(1998-12-29));

        assertEquals("Renda: R$ 3000.00", resposta.getBody());
        assertEquals(200, resposta.getStatusCode().value());
    }

    @Test
    void adicionaNovaPessoa() {
        Pessoa pessoa = new Pessoa();

        when(repository.save(pessoa)).thenReturn(pessoa);
        ResponseEntity resposta = controller.save(pessoa);

        assertEquals(pessoa, resposta.getBody());
    }

    @Test
    void atualizaPessoaPorId() {
        Pessoa pessoa = new Pessoa();

        when(repository.findById(1)).thenReturn(java.util.Optional.of(pessoa));

        ResponseEntity resposta = controller.atualizarPessoa(1, pessoa);

        assertEquals(400, resposta.getStatusCode().value());
        assertNull(resposta.getBody());
    }

    @Test
    void autenticaPorId() {
        Pessoa pessoa = new Pessoa();

        when(repository.findById(1)).thenReturn(java.util.Optional.of(pessoa));

        ResponseEntity resposta = controller.updateStatus(1);

        assertEquals(400, resposta.getStatusCode().value());
        assertNull(resposta.getBody());

    }
}