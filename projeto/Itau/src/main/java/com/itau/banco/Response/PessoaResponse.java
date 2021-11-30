package com.itau.banco.Response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaResponse {

    private Integer id_usuario;
    private String nome;
    private String cpf;
}
