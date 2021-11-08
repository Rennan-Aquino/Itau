package com.itau.banco.service;

import com.itau.banco.domain.Pessoa;
import com.itau.banco.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
//import java.util.concurrent.ThreadLocalRandom;

@Service
public class PessoaService {
    private static List<Pessoa> pessoas;

    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Pessoa>findAll() {
        return pessoaRepository.findAll();
    }

    public Pessoa findById(Integer id) {
        Optional<Pessoa> obj = pessoaRepository.findById(id);
        return obj.get();
    }

//    public Pessoa save(Pessoa novaPessoa) {
//        //novaPessoa.setId(ThreadLocalRandom.current().nextInt(1, 10));
//        pessoas.add(novaPessoa);
//        return novaPessoa;
    }
