package com.trabalhoFinal.trabalhoFinal.models;

import java.sql.Date;
import java.util.Objects;

public class Solicitacao {
    private int cod_solicitacao;
    private String titulo;
    private String descricao;
    private Date dt_hora_criacao;
    private Date dt_hora_finalizacao;
    private String status_solicitacao;
    private int cod_dispositivo;

    public Solicitacao(int cod_solicitacao, String titulo, String descricao, Date dt_hora_criacao,
                       Date dt_hora_finalizacao, String status_solicitacao, int cod_dispositivo) {
        this.cod_solicitacao = cod_solicitacao;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dt_hora_criacao = dt_hora_criacao;
        this.dt_hora_finalizacao = dt_hora_finalizacao;
        this.status_solicitacao = status_solicitacao;
        this.cod_dispositivo = cod_dispositivo;
    }

    public int getCod_solicitacao() {
        return cod_solicitacao;
    }

    public void setCod_solicitacao(int cod_solicitacao) {
        this.cod_solicitacao = cod_solicitacao;
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

    public Date getDt_hora_criacao() {
        return dt_hora_criacao;
    }

    public void setDt_hora_criacao(Date dt_hora_criacao) {
        this.dt_hora_criacao = dt_hora_criacao;
    }

    public Date getDt_hora_finalizacao() {
        return dt_hora_finalizacao;
    }

    public void setDt_hora_finalizacao(Date dt_hora_finalizacao) {
        this.dt_hora_finalizacao = dt_hora_finalizacao;
    }

    public String getStatus_solicitacao() {
        return status_solicitacao;
    }

    public void setStatus_solicitacao(String status_solicitacao) {
        this.status_solicitacao = status_solicitacao;
    }

    public int getCod_dispositivo() {
        return cod_dispositivo;
    }

    public void setCod_dispositivo(int cod_dispositivo) {
        this.cod_dispositivo = cod_dispositivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Solicitacao that = (Solicitacao) o;
        return cod_solicitacao == that.cod_solicitacao &&
                cod_dispositivo == that.cod_dispositivo &&
                Objects.equals(titulo, that.titulo) &&
                Objects.equals(descricao, that.descricao) &&
                Objects.equals(dt_hora_criacao, that.dt_hora_criacao) &&
                Objects.equals(dt_hora_finalizacao, that.dt_hora_finalizacao) &&
                Objects.equals(status_solicitacao, that.status_solicitacao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_solicitacao, titulo, descricao, dt_hora_criacao, dt_hora_finalizacao, status_solicitacao, cod_dispositivo);
    }

    @Override
    public String toString() {
        return "Solicitacao{" +
                "cod_solicitacao=" + cod_solicitacao +
                ", titulo='" + titulo + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dt_hora_criacao=" + dt_hora_criacao +
                ", dt_hora_finalizacao=" + dt_hora_finalizacao +
                ", status_solicitacao='" + status_solicitacao + '\'' +
                ", cod_dispositivo=" + cod_dispositivo +
                '}';
    }
}

