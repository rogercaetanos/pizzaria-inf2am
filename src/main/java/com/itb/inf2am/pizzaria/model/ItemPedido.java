package com.itb.inf2am.pizzaria.model;

public class ItemPedido {

    private Integer id;
    private int quantidade;
    private String obsItem;
    private boolean statusItem;

    // Atributos de apoio
    private String message = "";

    private boolean isValid = true;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getObsItem() {
        return obsItem;
    }

    public void setObsItem(String obsItem) {
        this.obsItem = obsItem;
    }

    public boolean isStatusItem() {
        return statusItem;
    }

    public void setStatusItem(boolean statusItem) {
        this.statusItem = statusItem;
    }

    public String getMessage() {
        return message;
    }

    public boolean validarItemPedido() {

        return isValid;
    }
}
