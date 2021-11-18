//package com.itau.banco.repository;
//
//import org.junit.Before;
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class CpfTeste {
//
//    private CpfTeste c;
//
//    @Before
//    public void criarCpfPessoa() {
//         c = new CpfTeste();
//    }
//
//    private Map<String, String> cpfs = new HashMap<>();
//
//    @Test
//    void CpfVazio() {
//        assertTrue(c.estaVazio());
//    }
//
//    private boolean estaVazio() {
//        return cpfs.isEmpty();
//    }
//
//    @Test
//    public void umCpf() {
//        c.adicionaCpf("48492335809", "Matheus Rocha");
//        assertFalse(c.estaVazio());
//        assertEquals("Matheus Rocha", c.registrar("48492335809"));
//    }
//
//    private String registrar(String cpf) {
//        return cpfs.get(cpf);
//    }
//
//    private void adicionaCpf(String cpf, String nome) {
//        if(cpfs.containsKey(cpf)) {
//            cpf = registro(cpf) + (nome);
//        }
//        cpfs.put(cpf, nome);
//    }
//
//    private String registro(String cpf) {
//        return null;
//    }
//}