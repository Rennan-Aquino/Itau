package com.itau.banco.repository;

import com.itau.banco.Response.PessoaResponse;
import com.itau.banco.domain.Pessoa;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface PessoaRepository extends JpaRepository <Pessoa, Integer> {

   Pessoa findByCpf(String cpf); //consultar pessoa por cpf

   Page<Pessoa> findAll(Pageable pageable);

   @Query("select new com.itau.banco.Response.PessoaResponse(p.id_usuario, p.nome, p.cpf) from Pessoa p")
   List<PessoaResponse> listarPessoaResponse();

   @Modifying
   @Transactional
   @Query("update Pessoa p set p.id_usuario = ?1 where p.nome = ?2 and p.cpf = ?3")
   void atualizarPessoa(Integer id, String nome, String cpf);
}
