package com.trabalhoFinal.trabalhoFinal.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "solicitacao")
public class Solicitacao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_solicitacao")
    private Integer codSolicitacao;

    @Column(name = "titulo", nullable = false, length = 30)
    private String titulo;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "dt_hora_criacao")
    private Date dataHoraCriacao;

    @Column(name = "dt_hora_finalizacao")
    private Date dataHoraFinalizacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_solicitacao", length = 20)
    private StatusSolicitacao statusSolicitacao;

    @ManyToOne
    @JoinColumn(name = "cod_dispositivo", foreignKey = @ForeignKey(name = "fk_solicitacao_dispositivo"))
    private Dispositivo dispositivo;

    public enum StatusSolicitacao {
        AGUARDANDO_ATENDIMENTO,
        EM_ATENDIMENTO,
        ENCERRADO,
        CANCELADO
    }

    public Solicitacao() {
    }

    public Integer getCodSolicitacao() {
        return codSolicitacao;
    }

    public void setCodSolicitacao(Integer codSolicitacao) {
        this.codSolicitacao = codSolicitacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataHoraCriacao() {
        return dataHoraCriacao;
    }

    public void setDataHoraCriacao(Date dataHoraCriacao) {
        this.dataHoraCriacao = dataHoraCriacao;
    }

    public Date getDataHoraFinalizacao() {
        return dataHoraFinalizacao;
    }

    public void setDataHoraFinalizacao(Date dataHoraFinalizacao) {
        this.dataHoraFinalizacao = dataHoraFinalizacao;
    }

    public StatusSolicitacao getStatusSolicitacao() {
        return statusSolicitacao;
    }

    public void setStatusSolicitacao(StatusSolicitacao statusSolicitacao) {
        this.statusSolicitacao = statusSolicitacao;
    }

    public Dispositivo getDispositivo() {
        return dispositivo;
    }

    public void setDispositivo(Dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitacao that = (Solicitacao) o;
        return Objects.equals(codSolicitacao, that.codSolicitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codSolicitacao);
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "codSolicitacao=" + codSolicitacao +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataHoraCriacao=" + dataHoraCriacao +
                ", dataHoraFinalizacao=" + dataHoraFinalizacao +
                ", statusSolicitacao=" + statusSolicitacao +
                ", dispositivo=" + dispositivo +
                '}';
    }
}
