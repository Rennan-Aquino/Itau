package com.itau.banco.controller;

import com.itau.banco.Response.PessoaResponse;
import com.itau.banco.domain.Pessoa;
import com.itau.banco.repository.PessoaRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping
    public Page<Pessoa> listAll(Pageable pageable) {
        return pessoaRepository.findAll(pageable);
    }

    @GetMapping("/usuario")
    public List<PessoaResponse> getResponse() {
        return pessoaRepository.listarPessoaResponse();
    }

    @GetMapping("/usuario-cpf/{cpf}")
        public Pessoa getUsuario(@RequestParam PessoaResponse response) {
        Pessoa usuario = pessoaRepository.findByCpf(response.getCpf());
        return usuario;
    }

    @GetMapping("/por-cpf/{cpf}")
    public Pessoa getCpf(@PathVariable String cpf) {
        Pessoa usuario = pessoaRepository.findByCpf(cpf);
        return usuario;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Integer id) {
        return ResponseEntity.of(pessoaRepository.findById(id));
    }

    @GetMapping("/consultar-limite/{cpf}/{renda}/{data}")
    public ResponseEntity consultarLimite(@PathVariable String cpf,
                                          @PathVariable Double renda,                                 //yyyy-mm-dd
                                          @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) @PathVariable LocalDate data) {

        pessoaRepository.findByCpf(cpf);
        String totalRenda = String.format("Renda: R$ %.2f", (renda * 0.30));
        return new ResponseEntity<>(totalRenda, HttpStatus.OK);
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
    public ResponseEntity atualizarPessoa(@PathVariable int id, @PathVariable Pessoa pessoa) {
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





//    @PatchMapping("/atualizar-usuario")
//    public void atualizarPreco(@RequestBody PessoaRequest request) {
//        pessoaRepository.atualizarPessoa(request.getId_usuario(), request.getNome(), request.getCpf());
//    }
//    @GetMapping("/usuarios/")
//    public ResponseEntity buscarUrl(@RequestParam Integer id) {
//        return new ResponseEntity<>(HttpStatus.OK);
//    }