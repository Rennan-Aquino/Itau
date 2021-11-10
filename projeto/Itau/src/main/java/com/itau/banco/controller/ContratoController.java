package com.itau.banco.controller;

import com.itau.banco.domain.Contrato;
import com.itau.banco.domain.Pessoa;
import com.itau.banco.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contratos")
public class ContratoController {

    @Autowired
    private ContratoRepository contratoRepository;

    @GetMapping
    public ResponseEntity<List> findAll() {
        List<Contrato> list = contratoRepository.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contrato> findById(@PathVariable Integer id) {
        contratoRepository.findById(id);
        return ResponseEntity.of(contratoRepository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteContrato(@PathVariable int id) {
        if (contratoRepository.existsById(id)) {
            contratoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarContrato(@PathVariable int id, Contrato contrato) {
        if (contratoRepository.existsById(id)) {
            contrato.setId(id);
            contratoRepository.save(contrato);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Contrato> save(@RequestBody Contrato novoContrato) {
        contratoRepository.save(novoContrato);
        return ResponseEntity.status(201).build();
    }

}
