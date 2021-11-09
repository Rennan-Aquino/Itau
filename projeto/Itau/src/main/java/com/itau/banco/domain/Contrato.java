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

    private LocalDateTime dataInicio;

    private LocalDateTime dataFim;

    private int qtdParcelas;
    @ManyToOne
    private Pessoa pessoa;

    private BigDecimal valorLiquido;

    private BigDecimal valorBruto;
}
