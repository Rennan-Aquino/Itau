package com.itau.banco.domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tb_contrato")
public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contrato", nullable = false)
    private Integer id_contrato;

    @OneToMany(mappedBy = "id_usuario")
    private List<Pessoa> pessoas;
    
    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_final")
    private LocalDateTime dataFim;

    @Column(name = "quantidade_parcelas")
    private Integer qtdParcelas;

    @Column(name = "valor_liquido")
    private BigDecimal valorLiquido;

    @Column(name = "valor_bruto")
    private BigDecimal valorBruto;

}
