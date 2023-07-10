package com.trabalhoFinal.trabalhoFinal.models;

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
@Table(name = "dispositivo")
public class Dispositivo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_dispositivo")
    @Setter
    private Long id;

    @Column(name = "nome", columnDefinition = "VARCHAR(30)")
    private String nome;

    @Column(name = "descricao", columnDefinition = "VARCHAR(255)")
    private String descricao;

    @Column(name = "dt_cadastro", columnDefinition = "DATE")
    private Date dataDeCadastro;

    @Column(name = "dt_devolucao", columnDefinition = "DATE")
    private Date dataDeDevolucao;

    @OneToMany
    private List<Solicitacao> solicitacoes;

    @ManyToOne
    @JoinColumn(name = "cod_cliente", nullable = false)
    private Cliente cliente;

    @Transient
    private Long clienteId;

    public Dispositivo(Long id, String nome, String descricao, Date dataDeCadastro, Date dataDeDevolucao, List<Solicitacao> solicitacoes, Cliente cliente, Long clienteId) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.dataDeCadastro = dataDeCadastro;
        this.dataDeDevolucao = dataDeDevolucao;
        this.solicitacoes = solicitacoes;
        this.cliente = cliente;
        this.clienteId = clienteId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }

    public Date getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public void setDataDeDevolucao(Date dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;
    }

    public List<Solicitacao> getSolicitacoes() {
        return solicitacoes;
    }

    public void setSolicitacoes(List<Solicitacao> solicitacoes) {
        this.solicitacoes = solicitacoes;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Dispositivo that = (Dispositivo) o;

        if (!Objects.equals(id, that.id)) return false;
        if (!Objects.equals(nome, that.nome)) return false;
        if (!Objects.equals(descricao, that.descricao)) return false;
        if (!Objects.equals(dataDeCadastro, that.dataDeCadastro))
            return false;
        if (!Objects.equals(dataDeDevolucao, that.dataDeDevolucao))
            return false;
        if (!Objects.equals(solicitacoes, that.solicitacoes)) return false;
        if (!Objects.equals(cliente, that.cliente)) return false;
        return Objects.equals(clienteId, that.clienteId);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (dataDeCadastro != null ? dataDeCadastro.hashCode() : 0);
        result = 31 * result + (dataDeDevolucao != null ? dataDeDevolucao.hashCode() : 0);
        result = 31 * result + (solicitacoes != null ? solicitacoes.hashCode() : 0);
        result = 31 * result + (cliente != null ? cliente.hashCode() : 0);
        result = 31 * result + (clienteId != null ? clienteId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Dispositivo{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataDeCadastro=" + dataDeCadastro +
                ", dataDeDevolucao=" + dataDeDevolucao +
                ", solicitacoes=" + solicitacoes +
                ", cliente=" + cliente +
                ", clienteId=" + clienteId +
                '}';
    }
}
