package com.itau.banco.controller;

import com.itau.banco.domain.Contrato;
import com.itau.banco.service.ContratoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoService contratoService;

    @GetMapping
    public ResponseEntity<List> findAll() {
        List<Contrato> list = contratoService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> findById(@PathVariable Integer id) {
        Contrato obj = contratoService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
