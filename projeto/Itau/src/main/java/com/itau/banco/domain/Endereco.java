package com.itau.banco.domain;

import lombok.*;
import javax.persistence.*;
import java.util.List;
import java.util.Map.Entry;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_endereco")

public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_endereco", nullable = false)
    private Integer id_endereco;

    @OneToMany(mappedBy = "id_usuario")
    private List<Pessoa> pessoas;

    @Column(name = "logradouro")
    private String logradouro;

    @Column(name = "cidade")
    private String cidade;

    @Column(name = "estado")
    private String estado;

    @Column(name = "pais")
    private String pais;

    @Column(name = "complemento")
    private String complemento;

    @Column(name = "numero")
    private Integer numero;

}

