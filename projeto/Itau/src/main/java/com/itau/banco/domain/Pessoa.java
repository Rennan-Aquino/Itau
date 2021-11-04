package com.itau.banco.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "cpf", length = 11)
    private String cpf;

    private String nome;
    private LocalDateTime dataNascimento;
    private String rg;
    private String telefone;
    private String email;
    private String endereco;
    private String complemento;

}
