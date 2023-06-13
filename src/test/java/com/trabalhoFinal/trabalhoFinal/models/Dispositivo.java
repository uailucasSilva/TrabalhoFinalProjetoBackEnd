package com.trabalhoFinal.trabalhoFinal.models;

import java.sql.Date;
import java.util.Objects;

public class Dispositivo {
    private int cod_dispositivo;
    private String nome;
    private String descricao;
    private Date dt_cadastro;
    private Date dt_devolucao;
    private int cod_cliente;

    public Dispositivo(int cod_dispositivo, String nome, String descricao, Date dt_cadastro, Date dt_devolucao, int cod_cliente) {
        this.cod_dispositivo = cod_dispositivo;
        this.nome = nome;
        this.descricao = descricao;
        this.dt_cadastro = dt_cadastro;
        this.dt_devolucao = dt_devolucao;
        this.cod_cliente = cod_cliente;
    }

    public int getCod_dispositivo() {
        return cod_dispositivo;
    }

    public void setCod_dispositivo(int cod_dispositivo) {
        this.cod_dispositivo = cod_dispositivo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDt_cadastro() {
        return dt_cadastro;
    }

    public void setDt_cadastro(Date dt_cadastro) {
        this.dt_cadastro = dt_cadastro;
    }

    public Date getDt_devolucao() {
        return dt_devolucao;
    }

    public void setDt_devolucao(Date dt_devolucao) {
        this.dt_devolucao = dt_devolucao;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dispositivo that = (Dispositivo) o;

        if (cod_dispositivo != that.cod_dispositivo) return false;
        if (cod_cliente != that.cod_cliente) return false;
        if (!Objects.equals(nome, that.nome)) return false;
        if (!Objects.equals(descricao, that.descricao)) return false;
        if (!Objects.equals(dt_cadastro, that.dt_cadastro)) return false;
        return Objects.equals(dt_devolucao, that.dt_devolucao);
    }

    @Override
    public int hashCode() {
        int result = cod_dispositivo;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (dt_cadastro != null ? dt_cadastro.hashCode() : 0);
        result = 31 * result + (dt_devolucao != null ? dt_devolucao.hashCode() : 0);
        result = 31 * result + cod_cliente;
        return result;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "cod_dispositivo=" + cod_dispositivo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dt_cadastro=" + dt_cadastro +
                ", dt_devolucao=" + dt_devolucao +
                ", cod_cliente=" + cod_cliente +
                '}';
    }
}
