package com.itau.banco.domain;

import com.itau.banco.domain.enums.AutenticaStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_pessoa")

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_pessoa", nullable = false)
    private Integer id_usuario;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "id_contrato")
    private List<Contrato> contratos;

    @OneToMany(mappedBy = "id_endereco")
    private List<Endereco> enderecos;

    @Column(name = "autenticado")
    private Boolean autenticado;

    @Column(name = "rg", length = 8)
    private String rg;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

}
