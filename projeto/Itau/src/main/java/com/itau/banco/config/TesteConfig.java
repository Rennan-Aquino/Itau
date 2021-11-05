//package com.itau.banco.config;
//
//import com.itau.banco.domain.Pessoa;
//import com.itau.banco.repository.PessoaRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
//
//import java.util.Arrays;
//
//@Configuration
//@Profile("test")
//public class TesteConfig implements CommandLineRunner {
//
//    @Autowired
//    private PessoaRepository pessoaRepository;
//
//    @Override
//    public void run(String... args) throws Exception {
//
//        Pessoa p1 = new Pessoa(1, "48492335849", "André Silva", "21-05-1999", "42847329", "11992831567",
//                "andre.silva@hotmail.com", "Rua Diamantina", 55, "Casa");
//
//        pessoaRepository.saveAll(Arrays.asList(p1));
//    }
//}
