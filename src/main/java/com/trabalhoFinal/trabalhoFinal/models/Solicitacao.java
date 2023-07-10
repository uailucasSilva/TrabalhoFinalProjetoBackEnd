package com.trabalhoFinal.trabalhoFinal.models;

import com.trabalhoFinal.trabalhoFinal.enums.StatusSolicitacao;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    public Solicitacao(Long id, String titulo, String descricao, Date dataHoraCriacao, Date dataHoraFinalizacao, StatusSolicitacao statusSolicitacao, Dispositivo dispositivo, List<Atendimento> atendimentos) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHoraCriacao = dataHoraCriacao;
        this.dataHoraFinalizacao = dataHoraFinalizacao;
        this.statusSolicitacao = statusSolicitacao;
        this.dispositivo = dispositivo;
        this.atendimentos = atendimentos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Atendimento> getAtendimentos() {
        return atendimentos;
    }

    public void setAtendimentos(List<Atendimento> atendimentos) {
        this.atendimentos = atendimentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Solicitacao that = (Solicitacao) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(titulo, that.titulo)) return false;
        if (!Objects.equals(descricao, that.descricao)) return false;
        if (!Objects.equals(dataHoraCriacao, that.dataHoraCriacao))
            return false;
        if (!Objects.equals(dataHoraFinalizacao, that.dataHoraFinalizacao))
            return false;
        if (statusSolicitacao != that.statusSolicitacao) return false;
        if (!Objects.equals(dispositivo, that.dispositivo)) return false;
        return Objects.equals(atendimentos, that.atendimentos);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (titulo != null ? titulo.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (dataHoraCriacao != null ? dataHoraCriacao.hashCode() : 0);
        result = 31 * result + (dataHoraFinalizacao != null ? dataHoraFinalizacao.hashCode() : 0);
        result = 31 * result + (statusSolicitacao != null ? statusSolicitacao.hashCode() : 0);
        result = 31 * result + (dispositivo != null ? dispositivo.hashCode() : 0);
        result = 31 * result + (atendimentos != null ? atendimentos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataHoraCriacao=" + dataHoraCriacao +
                ", dataHoraFinalizacao=" + dataHoraFinalizacao +
                ", statusSolicitacao=" + statusSolicitacao +
                ", dispositivo=" + dispositivo +
                ", atendimentos=" + atendimentos +
                '}';
    }
}