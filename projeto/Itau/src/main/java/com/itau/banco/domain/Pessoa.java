package com.itau.banco.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tb_usuario")
@Entity

public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id;
    @Column(name = "cpf", length = 11)
    private String cpf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;
    @Column(name = "rg", length = 8)
    private String rg;
    @Column(name = "telefone")
    private String telefone;
    @Column(name = "email")
    private String email;
    @Column(name = "endereco")
    private String endereco;
    @Column(name = "numero")
    private int numero;
    @Column(name = "complemento")
    private String complemento;

    public Pessoa(int id, String cpf, String nome, String dataNascimento, String rg, String telefone, String email, String endereco, int numero, String casa) {
    }

}
