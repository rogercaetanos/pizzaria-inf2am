package com.itb.inf2am.pizzaria.model;


import jakarta.persistence.*;

@Entity
@Table(name = "Cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = true, length = 20)
    private String telefone;
    @Column(nullable = true, length = 100)
    private String logradouro;
    @Column(nullable = true, length = 10)
    private String numero;
    @Column(nullable = true, length = 100)
    private String complemento;
    @Column(nullable = true, length = 8)
    private String cep;
    @Column(nullable = true, length = 50)
    private String bairro;
    @Column(nullable = true, length = 50)
    private String cidade;
    @Column(nullable = false, length = 10)
    private String statusCliente;

    // Atributos de apoio

    @Transient
    private String message = "";

    @Transient
    private boolean isValid = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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

    public String getStatusCliente() {
        return statusCliente;
    }

    public void setStatusCliente(String statusCliente) {
        this.statusCliente = statusCliente;
    }

    public String getMessage() {
        return message;
    }

    public boolean validarCliente() {

        return isValid;
    }
}
