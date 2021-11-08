package com.itau.banco.controller;

import com.itau.banco.domain.Pessoa;
import com.itau.banco.repository.PessoaRepository;
import com.itau.banco.service.PessoaService;
import com.itau.banco.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("/clientes")
public class PessoaController {

    @Autowired
    private PessoaRepository pessoaRepository;
    private PessoaService pessoaService;
    private DateUtil dateUtil;


    @GetMapping
    public ResponseEntity findAll() {
     //   log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        List<Pessoa> list = pessoaRepository.findAll();
        if(list.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        Pessoa obj = pessoaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping("/consultar-limite/{cpf}/{renda}")
    public ResponseEntity consultarLimite(@PathVariable String cpf,
                                          @PathVariable Double renda
                                          ) { //@PathVariable LocalDate dataNascimento

        List<Pessoa> list = pessoaRepository.findAll();
        for(Pessoa p : list) {
            if(p.getCpf().equals(cpf)) {
                //double totalRenda = String.format("%1$,.2f",(/0.30));
                //String totalRenda = String.format("Renda: R$ %.2f", (double)(renda * 30) /100);
                String totalRenda = String.format("Renda: R$ %.2f", (double)(renda * 0.30));
                return ResponseEntity.ok().body(totalRenda);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pessoa> save(@RequestBody Pessoa novaPessoa) {
//        return new ResponseEntity<>(pessoaService.save(novaPessoa), HttpStatus.CREATED);
        pessoaRepository.save(novaPessoa);
        return ResponseEntity.status(201).build();

    }
}
