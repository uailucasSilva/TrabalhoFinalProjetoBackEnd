package com.trabalhoFinal.trabalhoFinal.models;

import com.trabalhoif.if2023.enums.NivelDeAcesso;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor
@Table(name = "atendente")
public class Atendente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_atendente")
    @Setter
    private Long id;

    @Column(name = "nome", columnDefinition = "VARCHAR(70)")
    private String nome;

    @Column(name = "nro_matricula", columnDefinition = "CHAR(11)")
    private String numeroDaMatricula;

    @Column(name = "dt_nasc", columnDefinition = "DATE")
    private Date dataDeNascimento;

    @Column(name = "telefone", columnDefinition = "CHAR(15)")
    private String telefone;

    @Column(name = "email", columnDefinition = "VARCHAR(100)")
    private String email;

    @Column(name = "senha", columnDefinition = "VARCHAR(255)")
    private String senha;

    @Enumerated(EnumType.STRING)
    @Column(name = "nvl_acesso")
    private NivelDeAcesso nivelDeAcesso;

    @OneToMany(mappedBy = "atendente")
    private List<Atendimento> atendimentos;


    public Atendente(Long id, String nome, String numeroDaMatricula, Date dataDeNascimento, String telefone, String email, String senha, NivelDeAcesso nivelDeAcesso, List<Atendimento> atendimentos) {
        this.id = id;
        this.nome = nome;
        this.numeroDaMatricula = numeroDaMatricula;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.nivelDeAcesso = nivelDeAcesso;
        this.atendimentos = atendimentos;
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

    public String getNumeroDaMatricula() {
        return numeroDaMatricula;
    }

    public void setNumeroDaMatricula(String numeroDaMatricula) {
        this.numeroDaMatricula = numeroDaMatricula;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
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

    public NivelDeAcesso getNivelDeAcesso() {
        return nivelDeAcesso;
    }

    public void setNivelDeAcesso(NivelDeAcesso nivelDeAcesso) {
        this.nivelDeAcesso = nivelDeAcesso;
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

        Atendente atendente = (Atendente) o;

        if (!Objects.equals(id, atendente.id)) return false;
        if (!Objects.equals(nome, atendente.nome)) return false;
        if (!Objects.equals(numeroDaMatricula, atendente.numeroDaMatricula))
            return false;
        if (!Objects.equals(dataDeNascimento, atendente.dataDeNascimento))
            return false;
        if (!Objects.equals(telefone, atendente.telefone)) return false;
        if (!Objects.equals(email, atendente.email)) return false;
        if (!Objects.equals(senha, atendente.senha)) return false;
        if (nivelDeAcesso != atendente.nivelDeAcesso) return false;
        return Objects.equals(atendimentos, atendente.atendimentos);
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (numeroDaMatricula != null ? numeroDaMatricula.hashCode() : 0);
        result = 31 * result + (dataDeNascimento != null ? dataDeNascimento.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (nivelDeAcesso != null ? nivelDeAcesso.hashCode() : 0);
        result = 31 * result + (atendimentos != null ? atendimentos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Atendente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroDaMatricula='" + numeroDaMatricula + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", nivelDeAcesso=" + nivelDeAcesso +
                ", atendimentos=" + atendimentos +
                '}';
    }
}
