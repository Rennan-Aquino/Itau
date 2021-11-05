package com.itau.banco.controller;

import com.itau.banco.domain.Pessoa;
import com.itau.banco.service.PessoaService;
import com.itau.banco.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/clientes")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;
    private DateUtil dateUtil;

    @GetMapping
    public ResponseEntity<List> findAll() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        List<Pessoa> list = pessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        Pessoa obj = pessoaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa novaPessoa) {
//        return new ResponseEntity<>(pessoaService.save(novaPessoa), HttpStatus.CREATED);
        pessoaService.save(novaPessoa);
        return ResponseEntity.status(201).build();

    }
}
