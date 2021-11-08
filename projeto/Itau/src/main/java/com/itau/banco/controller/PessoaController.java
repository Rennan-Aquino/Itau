package com.itau.banco.controller;

import com.itau.banco.domain.Pessoa;
import com.itau.banco.repository.PessoaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

    @GetMapping
    public ResponseEntity findAll() {
        List<Pessoa> list = pessoaRepository.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        return ResponseEntity.of(pessoaRepository.findById(id));
    }

    @GetMapping("/consultar-limite/{cpf}/{renda}/{data}")
    public ResponseEntity consultarLimite(@PathVariable String cpf,
                                          @PathVariable Double renda,                                 //yyyy-mm-dd
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)@PathVariable LocalDate data){

        List<Pessoa> list = pessoaRepository.findAll();
        for (Pessoa p : list) {
            if (p.getCpf().equals(cpf) && p.getDataNascimento().equals(data)) {
                String totalRenda = String.format("Renda: R$ %.2f", (renda * 0.30));
                return ResponseEntity.ok().body(totalRenda);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa novaPessoa) {
        pessoaRepository.save(novaPessoa);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletePessoa(@PathVariable int id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity atualizarPessoa(@PathVariable int id, @RequestBody Pessoa pessoa) {
        if (pessoaRepository.existsById(id)) {
            pessoa.setId(id);
            pessoaRepository.save(pessoa);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
