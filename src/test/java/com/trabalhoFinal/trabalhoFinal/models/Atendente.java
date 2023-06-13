package com.trabalhoFinal.trabalhoFinal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "atendente")
public class Atendente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_atendente")
    private Integer codAtendente;

    @Column(name = "nome", length = 70)
    private String nome;

    @Column(name = "nro_matricula", length = 11)
    private String numeroMatricula;

    @Column(name = "dt_nasc")
    private java.sql.Date dataNascimento;

    @Column(name = "telefone", length = 15)
    private String telefone;

    @Column(name = "email", length = 100)
    private String email;

    @Column(name = "senha", length = 255)
    private String senha;

    @Column(name = "nvl_acesso")
    private int nivelAcesso;

    public Atendente() {
    }

    public Integer getCodAtendente() {
        return codAtendente;
    }

    public void setCodAtendente(Integer codAtendente) {
        this.codAtendente = codAtendente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(String numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public java.sql.Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(java.sql.Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Atendente atendente = (Atendente) o;
        return Objects.equals(codAtendente, atendente.codAtendente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codAtendente);
    }

    @Override
    public String toString() {
        return "Atendente{" +
                "codAtendente=" + codAtendente +
                ", nome='" + nome + '\'' +
                ", numeroMatricula='" + numeroMatricula + '\'' +
                ", dataNascimento=" + dataNascimento +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nivelAcesso=" + nivelAcesso +
                '}';
    }
}
