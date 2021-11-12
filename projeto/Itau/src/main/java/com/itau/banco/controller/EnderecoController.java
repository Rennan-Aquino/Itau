package com.itau.banco.controller;

import com.itau.banco.domain.Contrato;
import com.itau.banco.domain.Endereco;
import com.itau.banco.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public ResponseEntity<List> findAll() {
        List<Endereco> list = enderecoRepository.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Integer id) {
        enderecoRepository.findById(id);
        return ResponseEntity.of(enderecoRepository.findById(id));
    }

    @PostMapping
    public ResponseEntity<Endereco> save(@RequestBody Endereco endereco) {
        enderecoRepository.save(endereco);
        return new ResponseEntity<>(enderecoRepository.save(endereco), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarEndereco(@PathVariable int id, Endereco endereco) {
        if (enderecoRepository.existsById(id)) {
            endereco.setId_endereco(id);
            enderecoRepository.save(endereco);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteEndereco(@PathVariable int id) {
        if (enderecoRepository.existsById(id)) {
            enderecoRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

}
