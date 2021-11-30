package com.itau.banco.Request;

import lombok.Getter;

@Getter
public class PessoaRequest {

    //Está classe é um DTO (Objeto de Transferência de dados) ele é usado para envio de dados (REQUEST)
    private Integer id_usuario;
    private String nome;
    private String cpf;
}
