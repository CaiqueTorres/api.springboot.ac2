package com.example.ac1.models;

import java.util.Date;

public class Pedido {

    public int codigo;
    public float valor;
    public String descricao;
    public String cliente;
    public Date data;

    public Pedido() {}

    public Pedido(int codigo, float valor, String descricao, String cliente, Date data) {
        this.codigo = codigo;
        this.valor = valor;
        this.descricao = descricao;
        this.cliente = cliente;
        this.data = data;
    }

}
