package com.trabalhoFinal.trabalhoFinal.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Builder
@NoArgsConstructor
@Table(name = "cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_cliente")
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

    @Column(name = "rua", columnDefinition = "VARCHAR(70)")
    private String rua;

    @Column(name = "nro", columnDefinition = "VARCHAR(15)")
    private String numeroDaCasa;

    @Column(name = "bairro", columnDefinition = "VARCHAR(30)")
    private String bairro;

    @Column(name = "cidade", columnDefinition = "VARCHAR(40)")
    private String cidade;

    @Column(name = "cep", columnDefinition = "VARCHAR(9)")
    private String cep;

    @OneToMany
    private List<Dispositivo> dispositivos;

    public Cliente(Long id, String nome, String numeroDaMatricula, Date dataDeNascimento, String telefone, String email,
            String senha, String rua, String numeroDaCasa, String bairro, String cidade, String cep,
            List<Dispositivo> dispositivos) {
        this.id = id;
        this.nome = nome;
        this.numeroDaMatricula = numeroDaMatricula;
        this.dataDeNascimento = dataDeNascimento;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.rua = rua;
        this.numeroDaCasa = numeroDaCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
        this.dispositivos = dispositivos;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public void setNumeroDaCasa(String numeroDaCasa) {
        this.numeroDaCasa = numeroDaCasa;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Cliente cliente = (Cliente) o;

        if (!Objects.equals(id, cliente.id))
            return false;
        if (!Objects.equals(nome, cliente.nome))
            return false;
        if (!Objects.equals(numeroDaMatricula, cliente.numeroDaMatricula))
            return false;
        if (!Objects.equals(dataDeNascimento, cliente.dataDeNascimento))
            return false;
        if (!Objects.equals(telefone, cliente.telefone))
            return false;
        if (!Objects.equals(email, cliente.email))
            return false;
        if (!Objects.equals(senha, cliente.senha))
            return false;
        if (!Objects.equals(rua, cliente.rua))
            return false;
        if (!Objects.equals(numeroDaCasa, cliente.numeroDaCasa))
            return false;
        if (!Objects.equals(bairro, cliente.bairro))
            return false;
        if (!Objects.equals(cidade, cliente.cidade))
            return false;
        if (!Objects.equals(cep, cliente.cep))
            return false;
        return Objects.equals(dispositivos, cliente.dispositivos);
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
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (numeroDaCasa != null ? numeroDaCasa.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        result = 31 * result + (dispositivos != null ? dispositivos.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numeroDaMatricula='" + numeroDaMatricula + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", rua='" + rua + '\'' +
                ", numeroDaCasa='" + numeroDaCasa + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                ", dispositivos=" + dispositivos +
                '}';
    }
}