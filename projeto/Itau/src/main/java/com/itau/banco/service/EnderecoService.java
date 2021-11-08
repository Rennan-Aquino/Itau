//package com.itau.banco.service;
//
//import com.itau.banco.domain.Endereco;
//import com.itau.banco.repository.EnderecoRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EnderecoService {
//
//    @Autowired
//    private EnderecoRepository enderecoRepository;
//
//    public List<Endereco> findAll() {
//        return enderecoRepository.findAll();
//    }
//
//    public Endereco findById(Integer id) {
//        Optional<Endereco> obj = enderecoRepository.findById(id);
//        return obj.get();
//    }
//}
