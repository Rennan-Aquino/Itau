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
@Entity
@Table(name = "tb_pessoa")

public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuario", nullable = false)
    private Integer id_usuario;

    @Column(name = "cpf", length = 11)
    private String cpf;

    @Column(name = "nome")
    private String nome;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @OneToMany(mappedBy = "id_contrato")
    //@JoinColumn(name="id_contrato")
    private List<Contrato> contratos;

    @Column(name = "autenticado")
    private Boolean autenticado;

    @Column(name = "rg", length = 8)
    private String rg;

    @Column(name = "telefone")
    private String telefone;

    @Column(name = "email")
    private String email;

    @Column(name = "endereco")
    private String endereco;

    @Column(name = "numero")
    private String numero;

    @Column(name = "complemento")
    private String complemento;

    public Pessoa() {

    }

}
