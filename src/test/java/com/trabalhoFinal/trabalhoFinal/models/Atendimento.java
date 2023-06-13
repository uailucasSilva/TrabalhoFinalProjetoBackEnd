package com.trabalhoFinal.trabalhoFinal.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "atendimento")
public class Atendimento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_atendimento")
    private Integer codAtendimento;

    @ManyToOne
    @JoinColumn(name = "cod_atendente", foreignKey = @ForeignKey(name = "fk_atendimento_atendente"))
    private Atendente atendente;

    @ManyToOne
    @JoinColumn(name = "cod_solicitacao", foreignKey = @ForeignKey(name = "fk_atendimento_solicitacao"))
    private Solicitacao solicitacao;

    @Column(name = "dt_hora_atendimento")
    private Date dataHoraAtendimento;

    @Column(name = "observacao", length = 255)
    private String observacao;

    public Atendimento() {
    }

    public Integer getCodAtendimento() {
        return codAtendimento;
    }

    public void setCodAtendimento(Integer codAtendimento) {
        this.codAtendimento = codAtendimento;
    }

    public Atendente getAtendente() {
        return atendente;
    }

    public void setAtendente(Atendente atendente) {
        this.atendente = atendente;
    }

    public Solicitacao getSolicitacao() {
        return solicitacao;
    }

    public void setSolicitacao(Solicitacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    public Date getDataHoraAtendimento() {
        return dataHoraAtendimento;
    }

    public void setDataHoraAtendimento(Date dataHoraAtendimento) {
        this.dataHoraAtendimento = dataHoraAtendimento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atendimento that = (Atendimento) o;
        return Objects.equals(codAtendimento, that.codAtendimento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAtendimento);
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "codAtendimento=" + codAtendimento +
                ", atendente=" + atendente +
                ", solicitacao=" + solicitacao +
                ", dataHoraAtendimento=" + dataHoraAtendimento +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
