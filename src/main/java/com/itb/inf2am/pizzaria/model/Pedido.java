package com.itb.inf2am.pizzaria.model;

import java.time.LocalDateTime;

public class Pedido {

    private Integer id;
    private LocalDateTime dataPedido;
    private double valor;
    private String observacao;
    private String statusPedido;

    // Atributos de apoio
    private String message = "";

    private boolean isValid = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDataPedido() {
        return dataPedido;
    }

    public void setDataPedido(LocalDateTime dataPedido) {
        this.dataPedido = dataPedido;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(String statusPedido) {
        this.statusPedido = statusPedido;
    }

    public String getMessage() {
        return message;
    }

    public boolean validarPedido() {

        return isValid;
    }
}
