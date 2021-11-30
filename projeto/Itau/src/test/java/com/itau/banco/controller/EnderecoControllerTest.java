package com.itau.banco.controller;

import com.itau.banco.domain.Endereco;
import com.itau.banco.domain.Pessoa;
import com.itau.banco.repository.EnderecoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {EnderecoController.class, EnderecoRepository.class})
class EnderecoControllerTest {

    @Autowired
    EnderecoController controller;

    @MockBean
    EnderecoRepository repository;

    @Test
    void getEnderecoPorId() {
        Endereco endereco = new Endereco();

        when(repository.findById(1)).thenReturn(java.util.Optional.of(endereco));

        ResponseEntity resposta = controller.findById(1);

        assertEquals(200, resposta.getStatusCode().value());
        assertEquals(endereco, resposta.getBody());
    }

    @Test
    void adicionaEndereco() {
        Endereco endereco = new Endereco();

        when(repository.save(endereco)).thenReturn(endereco);
        ResponseEntity resposta = controller.save(endereco);

        assertEquals(201, resposta.getStatusCode().value());
        assertEquals(endereco, resposta.getBody());
    }

    @Test
    void atualizaEnderecoPorId() {
        Endereco endereco = new Endereco();
        endereco.setId_endereco(1);

        when(repository.findById(1)).thenReturn(java.util.Optional.of(endereco));

        ResponseEntity resposta = controller.atualizarEndereco(1, endereco);

        assertEquals(400, resposta.getStatusCode().value());
        assertNull(resposta.getBody());
    }

    @Test
    void deletaPorId() {
        Endereco endereco = new Endereco();

        when(repository.findById(1)).thenReturn(java.util.Optional.of(endereco));

        ResponseEntity resposta = controller.deleteEndereco(1);

        assertEquals(400, resposta.getStatusCode().value());
        assertNull(resposta.getBody());
    }

}