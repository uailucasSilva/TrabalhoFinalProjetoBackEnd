package com.trabalhoFinal.trabalhoFinal.models;

import java.sql.Date;
import java.util.Objects;

public class Cliente {
    private int cod_cliente;
    private String nome;
    private String nro_matricula;
    private Date dt_nasc;
    private String telefone;
    private String email;
    private String senha;
    private String rua;
    private String nro;
    private String bairro;
    private String cidade;
    private String cep;

    public Cliente(int cod_cliente, String nome, String nro_matricula, Date dt_nasc, String telefone, String email,
                   String senha, String rua, String nro, String bairro, String cidade, String cep) {
        this.cod_cliente = cod_cliente;
        this.nome = nome;
        this.nro_matricula = nro_matricula;
        this.dt_nasc = dt_nasc;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.rua = rua;
        this.nro = nro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (cod_cliente != cliente.cod_cliente) return false;
        if (!Objects.equals(nome, cliente.nome)) return false;
        if (!Objects.equals(nro_matricula, cliente.nro_matricula))
            return false;
        if (!Objects.equals(dt_nasc, cliente.dt_nasc)) return false;
        if (!Objects.equals(telefone, cliente.telefone)) return false;
        if (!Objects.equals(email, cliente.email)) return false;
        if (!Objects.equals(senha, cliente.senha)) return false;
        if (!Objects.equals(rua, cliente.rua)) return false;
        if (!Objects.equals(nro, cliente.nro)) return false;
        if (!Objects.equals(bairro, cliente.bairro)) return false;
        if (!Objects.equals(cidade, cliente.cidade)) return false;
        return Objects.equals(cep, cliente.cep);
    }

    @Override
    public int hashCode() {
        int result = cod_cliente;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (nro_matricula != null ? nro_matricula.hashCode() : 0);
        result = 31 * result + (dt_nasc != null ? dt_nasc.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (senha != null ? senha.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (nro != null ? nro.hashCode() : 0);
        result = 31 * result + (bairro != null ? bairro.hashCode() : 0);
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        result = 31 * result + (cep != null ? cep.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "cod_cliente=" + cod_cliente +
                ", nome='" + nome + '\'' +
                ", nro_matricula='" + nro_matricula + '\'' +
                ", dt_nasc=" + dt_nasc +
                ", telefone='" + telefone + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", rua='" + rua + '\'' +
                ", nro='" + nro + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cidade='" + cidade + '\'' +
                ", cep='" + cep + '\'' +
                '}';
    }

}
