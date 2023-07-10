package com.trabalhoFinal.trabalhoFinal.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "atendimento")
public class Atendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_atendimento")
    @Setter
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cod_atendente", nullable = false)
    private Atendente atendente;

    @ManyToOne
    @JoinColumn(name = "cod_solicitacao", nullable = false)
    private Solicitacao solicitacao;

    @Column(name = "dt_hora_atendimento", columnDefinition = "DATETIME")
    private Date dataHoraDoAtendimento;

    @Column(name = "observacao", columnDefinition = "VARCHAR(255)")
    private String observacao;



}
