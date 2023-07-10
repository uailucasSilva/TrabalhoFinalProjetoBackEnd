package com.trabalhoFinal.trabalhoFinal.models;

import com.trabalhoif.if2023.enums.StatusSolicitacao;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "solicitacao")
public class Solicitacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_solicitacao")
    @Setter
    private Long id;

    @Column(name = "titulo", columnDefinition = "VARCHAR(30)")
    private String titulo;

    @Column(name = "descricao", columnDefinition = "VARCHAR(255)")
    private String descricao;

    @Column(name = "dt_hora_criacao", columnDefinition = "DATETIME")
    private Date dataHoraCriacao;

    @Column(name = "dt_hora_finalizacao", columnDefinition = "DATETIME")
    private Date dataHoraFinalizacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_solicitacao")
    private StatusSolicitacao statusSolicitacao;

    @ManyToOne
    @JoinColumn(name = "cod_dispositivo", nullable = false)
    private Dispositivo dispositivo;

    @OneToMany
    private List<Atendimento> atendimentos;

}