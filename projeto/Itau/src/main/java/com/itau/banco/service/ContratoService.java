package com.itau.banco.service;

import com.itau.banco.domain.Contrato;
import com.itau.banco.repository.ContratoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContratoService {

    @Autowired
    private ContratoRepository contratoRepository;

    public List<Contrato> findAll() {
        return contratoRepository.findAll();
    }

    public Contrato findById(Integer id) {
        Optional<Contrato> obj = contratoRepository.findById(id);
        return obj.get();
    }
}
