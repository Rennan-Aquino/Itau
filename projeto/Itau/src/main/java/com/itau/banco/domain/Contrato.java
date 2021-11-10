package com.itau.banco.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity

public class Contrato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "data_inicio")
    private LocalDateTime dataInicio;

    @Column(name = "data_final")
    private LocalDateTime dataFim;

    @Column(name = "quantidade_parcelas")
    private Integer qtdParcelas;

    @ManyToOne
    private Pessoa pessoa;

    @Column(name = "valor_liquido'")
    private BigDecimal valorLiquido;

    @Column(name = "valor_bruto")
    private BigDecimal valorBruto;
}
