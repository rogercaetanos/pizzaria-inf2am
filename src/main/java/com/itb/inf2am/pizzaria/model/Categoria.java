package com.itb.inf2am.pizzaria.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Categoria")
public class Categoria {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO-INCREMENTO
    private Integer id;

    @Column(nullable = false, length = 50)
    private String nome;
    @Column(nullable = false, length = 50)
    private String descricao;

    // Atributos de apoio

    @Transient   // Significa que o referido atributo NÃO É COLUNA
    @JsonIgnore
    private String message = "";

    @Transient
    @JsonIgnore
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getMessage() {
        return message;
    }

    public boolean validarCategoria() {

        return isValid;
    }

}
