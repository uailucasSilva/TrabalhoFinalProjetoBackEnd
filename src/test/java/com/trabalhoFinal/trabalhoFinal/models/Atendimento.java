package com.trabalhoFinal.trabalhoFinal.models;

import java.sql.Date;
import java.util.Objects;

public class Atendimento {
    private int cod_atendimento;
    private int cod_atendente;
    private int cod_solicitacao;
    private Date dt_hora_atendimento;
    private String observacao;


    public Atendimento(int cod_atendimento, int cod_atendente, int cod_solicitacao, Date dt_hora_atendimento, String observacao) {
        this.cod_atendimento = cod_atendimento;
        this.cod_atendente = cod_atendente;
        this.cod_solicitacao = cod_solicitacao;
        this.dt_hora_atendimento = dt_hora_atendimento;
        this.observacao = observacao;
    }

    public int getCod_atendimento() {
        return cod_atendimento;
    }

    public void setCod_atendimento(int cod_atendimento) {
        this.cod_atendimento = cod_atendimento;
    }

    public int getCod_atendente() {
        return cod_atendente;
    }

    public void setCod_atendente(int cod_atendente) {
        this.cod_atendente = cod_atendente;
    }

    public int getCod_solicitacao() {
        return cod_solicitacao;
    }

    public void setCod_solicitacao(int cod_solicitacao) {
        this.cod_solicitacao = cod_solicitacao;
    }

    public Date getDt_hora_atendimento() {
        return dt_hora_atendimento;
    }

    public void setDt_hora_atendimento(Date dt_hora_atendimento) {
        this.dt_hora_atendimento = dt_hora_atendimento;
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
        return cod_atendimento == that.cod_atendimento &&
                cod_atendente == that.cod_atendente &&
                cod_solicitacao == that.cod_solicitacao &&
                Objects.equals(dt_hora_atendimento, that.dt_hora_atendimento) &&
                Objects.equals(observacao, that.observacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_atendimento, cod_atendente, cod_solicitacao, dt_hora_atendimento, observacao);
    }

    @Override
    public String toString() {
        return "Atendimento{" +
                "cod_atendimento=" + cod_atendimento +
                ", cod_atendente=" + cod_atendente +
                ", cod_solicitacao=" + cod_solicitacao +
                ", dt_hora_atendimento=" + dt_hora_atendimento +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}

