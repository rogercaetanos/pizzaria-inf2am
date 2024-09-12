package com.itb.inf2am.pizzaria.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Produto")
public class Produto {

    /*
      Encapsulamento: Proteger meus atributos do acesso descontrolado, evitar que outros
    * programadores utilize minha classe setando valores inválidos!

      O primeiro passo para obter o encapsulamento é trabalhar com os modificadores de acesso:
      Temos três:

      public    - Acesso livre para todas as classes
      private   - Acesso livre apenas dentro da própria classe
      protected - Acesso livre apenas para as classes filhas (Herança)

      1º PASSO: Altere o modificador de acesso dos atributos para private
      2º PASSO: Prover métodos para prover a comunicação entre objetos "troca de mensagens"
         Obs: Uma prática muito utilizada é trabalhar com os métodos SETTER´S E GETTER´S
         set -> responsável pela atribuição do valor ao atributo
         get -> responsável pela recuperação do valor do atributo

         Para cada atributo teremos um set e um get correspondente!
    * */

    @Id                                                          // PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)          // AUTO-INCREMENT
    private Integer id;
    @Column(nullable = false, length = 60)
    private String nome;
    @Column(nullable = false, length = 100)
    private String descricao;
    @Column(nullable = false, length = 30)
    private String codBarras;
    @Column(nullable = false, columnDefinition = "DECIMAL(5,2)")
    private double preco;
    @Column(nullable = false, length = 20)
    private String statusProd;

    // Atributos de apoio

    @Transient                             // NÃO REPRESENTA COLUNA DO BANCO
    private String message = "";
    @Transient
    private boolean isValid = true;


     // Setter e Getters


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

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
            this.preco = preco;
    }

    public String getStatusProd() {
        return statusProd;
    }

    public void setStatusProd(String statusProd) {
        this.statusProd = statusProd;
    }

    public String getMessage() {
        return  message;
    }


    // Validando o produto

    public boolean validarProduto() {
        if(preco < 0 ){
            message += "O preço do produto deve ser maior que zero:";
            isValid = false;
        }
        if(nome == null || nome.isEmpty()){
            message += "O nome do produto é obrigatório:";
            isValid = false;
        }

        return isValid;
    }

}
