package com.trabalhoFinal.trabalhoFinal.models;

import java.sql.Date;
import java.util.Objects;

public class Atendente {
    private int cod_atendente;
    private String nome;
    private String nro_matricula;
    private Date dt_nasc;
    private String telefone;
    private String email;
    private String senha;
    private int nvl_acesso;

    public Atendente(int cod_atendente, String nome, String nro_matricula, Date dt_nasc, String telefone,
                     String email, String senha, int nvl_acesso) {
        this.cod_atendente = cod_atendente;
        this.nome = nome;
        this.nro_matricula = nro_matricula;
        this.dt_nasc = dt_nasc;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.nvl_acesso = nvl_acesso;
    }

    public int getCod_atendente() {
        return cod_atendente;
    }

    public void setCod_atendente(int cod_atendente) {
        this.cod_atendente = cod_atendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNro_matricula() {
        return nro_matricula;
    }

    public void setNro_matricula(String nro_matricula) {
        this.nro_matricula = nro_matricula;
    }

    public Date getDt_nasc() {
        return dt_nasc;
    }

    public void setDt_nasc(Date dt_nasc) {
        this.dt_nasc = dt_nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getNvl_acesso() {
        return nvl_acesso;
    }

    public void setNvl_acesso(int nvl_acesso) {
        this.nvl_acesso = nvl_acesso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atendente atendente = (Atendente) o;
        return cod_atendente == atendente.cod_atendente &&
                Objects.equals(nome, atendente.nome) &&
                Objects.equals(nro_matricula, atendente.nro_matricula) &&
                Objects.equals(dt_nasc, atendente.dt_nasc) &&
                Objects.equals(telefone, atendente.telefone) &&
                Objects.equals(email, atendente.email) &&
                Objects.equals(senha, atendente.senha) &&
                nvl_acesso == atendente.nvl_acesso;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cod_atendente, nome, nro_matricula, dt_nasc, telefone, email, senha, nvl_acesso);
    }

    @Override
    public String toString() {
        return "Atendente{" +
                "cod_atendente=" + cod_atendente +
                ", nome='" + nome + '\'' +
                ", nro_matricula='" + nro_matricula + '\'' +
                ", dt_nasc=" + dt_nasc +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nvl_acesso=" + nvl_acesso +
                '}';
    }
}
