package com.trabalhoFinal.trabalhoFinal.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "dispositivo")
public class Dispositivo implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_dispositivo")
    private Integer codDispositivo;

    @Column(name = "nome", length = 30)
    private String nome;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "dt_cadastro")
    private Date dataCadastro;

    @Column(name = "dt_devolucao")
    private Date dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "cod_cliente", foreignKey = @ForeignKey(name = "fk_dispositivo_cliente"))
    private Cliente cliente;

    public Dispositivo() {
    }

    public Long getCodDispositivo() {
        return codDispositivo;
    }

    public void setCodDispositivo(Integer codDispositivo) {
        this.codDispositivo = codDispositivo;
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

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Date getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(Date dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dispositivo that = (Dispositivo) o;
        return Objects.equals(codDispositivo, that.codDispositivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codDispositivo);
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "codDispositivo=" + codDispositivo +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataCadastro=" + dataCadastro +
                ", dataDevolucao=" + dataDevolucao +
                ", cliente=" + cliente +
                '}';
    }
}
