package com.itau.banco.controller;

import com.itau.banco.domain.Contrato;
import com.itau.banco.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return new ResponseEntity<>(list, HttpStatus.OK);
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
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarContrato(@PathVariable int id, Contrato contrato) {
        if (contratoRepository.existsById(id)) {
            contrato.setId_contrato(id);
            contratoRepository.save(contrato);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping
    public ResponseEntity<Contrato> save(@RequestBody Contrato novoContrato) {
        contratoRepository.save(novoContrato);
        return new ResponseEntity<>(contratoRepository.save(novoContrato), HttpStatus.CREATED);
    }
}
