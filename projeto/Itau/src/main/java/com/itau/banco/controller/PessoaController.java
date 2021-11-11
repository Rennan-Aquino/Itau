package com.itau.banco.controller;


import com.itau.banco.domain.Pessoa;
import com.itau.banco.repository.PessoaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/clientes")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping("/por-cpf/{cpf}")
    public List<Pessoa> getCpf(@PathVariable String cpf) {
        return pessoaRepository.findByCpf(cpf);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        return ResponseEntity.of(pessoaRepository.findById(id));
    }

    @GetMapping("/consultar-limite/{cpf}/{renda}/{data}")
    public ResponseEntity consultarLimite(@PathVariable String cpf,
                                          @PathVariable Double renda,                                 //yyyy-mm-dd
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate data) {

        List<Pessoa> list = pessoaRepository.findByCpf(cpf);
        for (Pessoa p : list) {
            String totalRenda = String.format("Renda: R$ %.2f", (renda * 0.30));
            return new ResponseEntity<>(totalRenda, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa novaPessoa) {
        pessoaRepository.save(novaPessoa);
        return new ResponseEntity<>(pessoaRepository.save(novaPessoa), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePessoa(@PathVariable int id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarPessoa(@PathVariable int id, @RequestBody Pessoa pessoa) {
        if (pessoaRepository.existsById(id)) {
            pessoa.setId_usuario(id);
            pessoaRepository.save(pessoa);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/autenticacao/{id}")
    public ResponseEntity updateStatus(@PathVariable int id) {
        if (pessoaRepository.existsById(id)) {
            Pessoa pessoa = pessoaRepository.getById(id);
            pessoa.setAutenticado(false);
            pessoaRepository.save(pessoa);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
