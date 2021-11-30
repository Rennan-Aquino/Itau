package com.itau.banco.controller;

import com.itau.banco.domain.Contrato;
import com.itau.banco.repository.ContratoRepository;
import com.itau.banco.repository.EnderecoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.sql.Connection;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest(classes = {ContratoController.class, EnderecoRepository.class})
class ContratoControllerTest {

    @Autowired
    ContratoController controller;

    @MockBean
    ContratoRepository repository;

    @Test
    void getTodosContratos() {
        Contrato contrato = new Contrato();

        when(repository.findAll()).thenReturn(new ArrayList<>());

        ResponseEntity resposta = controller.findAll();

        assertEquals(200, resposta.getStatusCode().value());
    }

    @Test
    void getContratoPorId() {
        Contrato contrato = new Contrato();

        when(repository.findById(1)).thenReturn(java.util.Optional.of(contrato));

        ResponseEntity resposta = controller.findById(1);

        assertEquals(200, resposta.getStatusCode().value());
    }

    @Test
    void deleteContratoPorId() {
        Contrato contrato = new Contrato();

        when(repository.findById(1)).thenReturn(java.util.Optional.of(contrato));

        ResponseEntity resposta = controller.deleteContrato(1);

        assertEquals(400, resposta.getStatusCode().value());
        assertNull(resposta.getBody());
    }

    @Test
    void alterarContratoPorId() {
        Contrato contrato = new Contrato();
        contrato.setId_contrato(1);

        when(repository.findById(1)).thenReturn(java.util.Optional.of(contrato));

        ResponseEntity resposta = controller.atualizarContrato(1, contrato);

        assertEquals(400, resposta.getStatusCode().value());
        assertNull(resposta.getBody());
    }

}